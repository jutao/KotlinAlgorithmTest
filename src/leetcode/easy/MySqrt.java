package easy;

/**
 * ****************************************
 * author：琚涛
 * time：2019/1/25
 * description：69. x 的平方根
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * ****************************************
 */
public class MySqrt {
    public int mySqrt(int x) {
        long l = 1;
        long r = x;
        while (l <= r) {
            long m = l + (r - l) / 2;
            long sqrt=m*m;
            long sqrtPlus=(m+1)*(m+1);
            if(sqrt<=x&&sqrtPlus>x){
                return (int) m;
            }else if(sqrt<x){
                l=m+1;
            }else {
                r=m-1;
            }
        }
        return 0;
    }
}
