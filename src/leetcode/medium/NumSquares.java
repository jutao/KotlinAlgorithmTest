package leetcode.medium;

/**
 * author：jutao
 * time：2019/6/21
 * description：279. 完全平方数
 * tag:动态规划
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 */
public class NumSquares {
    public int numSquares(int n) {

        int[] numbers = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, numbers[i - j * j]);
                if (min == 1) {
                    break;
                }
            }
            numbers[i] = min + 1;
        }
        return numbers[n];
    }

}
