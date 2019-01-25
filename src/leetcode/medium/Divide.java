package medium;

/**
 * ****************************************
 * author：琚涛
 * time：2019/1/24
 * description：29. 两数相除
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * <p>
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * <p>
 * 示例 1:
 * <p>
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 说明:
 * <p>
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 * ****************************************
 */
public class Divide {
    public static void main(String[] args) {
        System.out.println(new Divide().divide(
                1004958205, -2137325331));
    }

    public int divide(int dividend, int divisor) {
        if (dividend == -2147483648 && divisor == -1) {
            return 2147483647;
        }
        if (dividend==0){
            return 0;
        }


        boolean negative = (dividend ^ divisor) < 0;

        long divisorLong=divisor;
        long dividendLong=dividend;
         divisorLong=Math.abs(divisorLong);
         dividendLong=Math.abs(dividendLong);

        if(dividendLong<divisorLong){
            return 0;
        }
        long result = divisorLong;
        long temp = 1;
        while ((result + result) <= dividendLong) {
            temp+=temp;
            result += result;

        }

        while ((result + divisorLong) <= dividendLong) {
            temp++;
            result += divisorLong;

        }
        return (int) (negative?-temp:temp);
    }
}
