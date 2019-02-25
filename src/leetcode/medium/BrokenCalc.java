package medium;

/**
 * ****************************************
 * author：琚涛
 * time：2019/2/25
 * description：991. 坏了的计算器
 * 在显示着数字的坏计算器上，我们可以执行以下两种操作：
 * <p>
 * 双倍（Double）：将显示屏上的数字乘 2；
 * 递减（Decrement）：将显示屏上的数字减 1 。
 * 最初，计算器显示数字 X。
 * <p>
 * 返回显示数字 Y 所需的最小操作数。
 * ****************************************
 */
public class BrokenCalc {
    public int brokenCalc(int X, int Y) {
        int time = 0;
        while (X < Y) {
            if(Y%2==0){
                Y/=2;
            }else {
                Y++;
            }
            time++;
        }
        return time + X - Y;
    }
}
