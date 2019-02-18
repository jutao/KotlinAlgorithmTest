package leetcode.medium;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("safee"));
    }

    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = -1;
        int res = 0;
        char[] chars = s.toCharArray();
        int[] freq = new int[256];
        while (l < s.length()) {
            if (r + 1 < chars.length && freq[chars[r + 1]] ==0) {
                freq[chars[++r]]++;
            } else {
                freq[chars[l++]]--;
            }
            res = Math.max(res, r - l + 1);
        }

        return res;

    }
}
