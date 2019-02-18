package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * <p>
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 * <p>
 * 说明：
 * <p>
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 */
public class FindAnagrams {
    public static void main(String[] args) {
        new FindAnagrams().findAnagrams("abaacaaba", "aa");
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] freq = new int[26];
        for (int i = 0; i < p.length(); i++) {
            freq[p.charAt(i) - 'a']++;
        }
        int l = 0;
        int r = -1;
        int count = 0;
        while (l < s.length()) {
            if(r+1>=s.length()){
                break;
            }
            if (freq[s.charAt(++r) - 'a']-- > 0) {
                count++;
            }
            if (count == p.length()) {
                res.add(l);
            }
            if (r - l + 1 == p.length()) {
                if (freq[s.charAt(l++)-'a']++ >= 0) {
                    count--;
                }
            }
        }
        return res;
    }
}
