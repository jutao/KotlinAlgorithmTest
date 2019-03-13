package easy;

/**
 * ****************************************
 * author：琚涛
 * time：2019/3/13
 * description：67. 二进制求和
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * <p>
 * 输入为非空字符串且只包含数字 1 和 0。
 * ****************************************
 */
public class AddBinary {
    public static void main(String[] args) {
        System.out.println(new AddBinary().addBinary("11", "1"));
    }

    public String addBinary(String a, String b) {
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        int aPoint = aChars.length - 1;
        int bPoint = bChars.length - 1;
        StringBuilder res = new StringBuilder();
        int carry = 0;
        while (aPoint >= 0 || bPoint >= 0 || carry != 0) {
            int aItem;
            int bItem;
            if (aPoint < 0) {
                aItem = 0;
            } else {
                aItem = aChars[aPoint--] - '0';
            }
            if (bPoint < 0) {
                bItem = 0;
            } else {
                bItem = bChars[bPoint--] - '0';
            }
            int result = aItem + bItem + carry;

            res.append(result % 2);
            carry = result / 2;
        }
        return res.reverse().toString();
    }
}
