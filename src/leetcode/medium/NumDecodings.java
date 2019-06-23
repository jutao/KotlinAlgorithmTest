package leetcode.medium;

/**
 * author：jutao
 * time：2019/6/23
 * description：91. 解码方法
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 */
public class NumDecodings {
    public static void main(String[] args) {
        System.out.println(new NumDecodings().numDecodings("10"));
    }

    public int numDecodings(String s) {
        if (s == null || s.length() == 0||s.charAt(0)=='0') {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        int pre1 = 1;
        int pre2 = 0;
        int cur = 1;
        for (int i = 0; i < s.length(); i++) {
            cur = s.charAt(i) == '0' ? 0 : pre1;
            if(i>0){
                int p=(s.charAt(i - 1) - '0') * 10 + s.charAt(i)-'0';
                if ( p<= 26&&p>=10) {
                    cur += pre2;
                }
            }
            pre2 = pre1;
            pre1 = cur;
        }
        return cur;
    }
}
