package leetcode.hard;

import java.util.Arrays;

/**
 * author：jutao
 * time：2019/6/21
 * description：343. 整数拆分
 * tag:动态规划
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 */
public class IntegerBreak {
    public static void main(String[] args) {
        System.out.println(new IntegerBreak().integerBreak(2));
    }

    private int max3(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    //递归方法
//    public int integerBreak(int n) {
//        int[] memory = new int[n + 1];
//        Arrays.fill(memory, -1);
//        return integerBreak(n, memory);
//    }
//
//    private int integerBreak(int n, int[] menory) {
//        if (n == 1) {
//            return 1;
//        }
//        int res = 0;
//        if (menory[n] != -1) {
//            return menory[n];
//        }
//        for (int i = 1; i <n; i++) {
//            res = max3(i * integerBreak(n - i, menory), res, i * (n - i));
//        }
//        menory[n] = res;
//        return res;
//    }

    //动态规划方法
    public int integerBreak(int n) {
        int[] memory = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <i; j++) {
                memory[i]=max3(memory[i-j]*j,j*(i-j),memory[i]);
            }
        }
        return memory[n];
    }
}
