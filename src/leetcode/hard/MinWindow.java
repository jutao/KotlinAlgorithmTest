package leetcode.hard;

/**
 * 76. 最小覆盖子串
 * 给定一个字符串 S 和一个字符串 T，请在 S 中找出包含 T 所有字母的最小子串。
 * <p>
 * 示例：
 * <p>
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 * <p>
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 */
public class MinWindow {
    public static void main(String[] args) {
        System.out.println(new MinWindow().minWindow("ADOBECODEBANC", "ADO"));
    }

    public String minWindow(String s, String t) {
        int[] dictionary = new int[256];
        for (int i = 0; i < t.length(); i++) {
            dictionary[t.charAt(i)]++;
        }
        int l = 0;
        int r = -1;
        int count = 0;
        int minLength = s.length() + 1;
        int start = 0;
        while (l < s.length()) {
            if (r + 1 < s.length() && count < t.length()) {
                if (dictionary[s.charAt(++r)]-- > 0) {
                    count++;
                }
            } else {
                if (dictionary[s.charAt(l++)]++ >= 0) {
                    count--;
                }
            }
            if (count == t.length()) {
                while (dictionary[s.charAt(l)] < 0) {
                    dictionary[s.charAt(l++)]++;
                }
                if (r - l + 1 < minLength) {
                    start = l;
                    minLength = r - l + 1;
                }
                dictionary[s.charAt(l++)]++;
                count--;
            }
        }
        if (minLength != s.length() + 1) {
            return s.substring(start, start + minLength);
        }
        return "";
    }
}
