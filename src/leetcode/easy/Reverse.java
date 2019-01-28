package easy;

/**
 * ****************************************
 * author：琚涛
 * time：2019/1/28
 * description：7. 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * ****************************************
 */
public class Reverse {
    public static void main(String[] args) {
        System.out.println(new Reverse().reverse(-1999483648));
    }

    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            if(result>Integer.MAX_VALUE/10||result<Integer.MIN_VALUE/10){
                return 0;
            }
            result = result * 10 + x % 10;
            x /= 10;
        }

        return  result;
    }
}
