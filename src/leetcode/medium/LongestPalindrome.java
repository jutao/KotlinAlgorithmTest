package medium;

/**
 * ****************************************
 * author：琚涛
 * time：2019/2/21
 * description：5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * ****************************************
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("abacab"));
    }

    // TODO: 2019/2/21 耗时过长，有待优化。
    public String longestPalindrome(String s) {
        if(s.length()<=1){
            return s;
        }

        int l = 0;
        int r = s.length() - 1;
        String substring;
        int start = 0;
        int end = 0;
        while (l < s.length()-1) {
            substring = s.substring(l, r + 1);
            if (isPalindrome(substring)) {
                if (r - l + 1 > end - start + 1) {
                    start = l;
                    end = r;
                }
                l++;
                r=s.length()-1;
                continue;
            }
            r--;
            if (r == l) {
                l++;
                r = s.length()-1;
            }
        }
        return s.substring(start,end+1);
    }

    private boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int l = 0;
        int r = chars.length - 1;
        while (l <= r) {
            if (chars[l++] != chars[r--]) {
                return false;
            }
        }
        return true;
    }
}
