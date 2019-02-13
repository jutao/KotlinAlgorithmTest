package leetcode.easy;

/**
 * 125. 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 */
public class IsPalindromeWord {
    public static void main(String[] args) {
        System.out.println(isPalindrome("  "));
    }

    public static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {

            while (!isWordOrNumber(s.charAt(i))) {
                if (i == s.length() - 1) {
                    return true;
                }
                i++;
            }
            while (!isWordOrNumber(s.charAt(j))) {
                if (j == 0) {
                    return true;
                }
                j--;
            }
            int top = s.charAt(i++);
            int tail = s.charAt(j--);

            if (top >= 'a' && top <= 'z') {
                top = top - ('a' - 'A');
            }
            if (tail >= 'a' && tail <= 'z') {
                tail = tail - ('a' - 'A');
            }


            if (top != tail) {
                return false;
            }
        }
        return true;
    }

    private static boolean isWordOrNumber(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        if (c >= 'a' && c <= 'z') {
            return true;
        }
        if (c >= 'A' && c <= 'Z') {
            return true;
        }
        return false;
    }
}
