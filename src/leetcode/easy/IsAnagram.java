package leetcode.easy;

/**
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * <p>
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
        }
        int count = 0;
        for (int i = 0; i < t.length(); i++) {
            if (map[t.charAt(i) - 'a']-- > 0) {
                count++;
            } else {
                return false;
            }
        }
        if (count != t.length()) {
            return false;
        }
        for (int i : map) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
