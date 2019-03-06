package easy;

/**
 * ****************************************
 * author：琚涛
 * time：2019/3/5
 * description：172. 阶乘后的零
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 * ****************************************
 */
public class TrailingZeroes {
    public int trailingZeroes(int n) {
        if (n < 5)
            return 0;
        else
            return n / 5 + trailingZeroes(n / 5);
    }
}
