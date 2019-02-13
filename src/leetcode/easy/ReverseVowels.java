package leetcode.easy;

/**
 * 345. 反转字符串中的元音字母
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "hello"
 * 输出: "holle"
 * 示例 2:
 * <p>
 * 输入: "leetcode"
 * 输出: "leotcede"
 * 说明:
 * 元音字母不包含字母"y"。
 */
public class ReverseVowels {
    public static void main(String[] args) {
        System.out.println(new ReverseVowels().reverseVowels(""));
    }

    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (true) {
            while (!isVowel(chars[i])) {
                if(i==s.length()-1){
                    return new String(chars);
                }
                i++;
            }
            while (!isVowel(chars[j])) {
                if(j==0){
                    return new String(chars);
                }
                j--;
            }
            if (i >= j) {
                break;
            }
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        return new String(chars);
    }

    private boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'A') {
            return true;
        }
        if (ch == 'e' || ch == 'E') {
            return true;
        }
        if (ch == 'i' || ch == 'I') {
            return true;
        }
        if (ch == 'o' || ch == 'O') {
            return true;
        }
        if (ch == 'u' || ch == 'U') {
            return true;
        }
        return false;
    }
}
