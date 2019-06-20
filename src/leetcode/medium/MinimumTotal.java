package leetcode.medium;

import java.util.List;

/**
 * author：jutao
 * time：2019/6/20
 * description：120. 三角形最小路径和
 * tag:动态规划
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 */
public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null) {
            return 0;
        }
        int m = triangle.size();
        int n = triangle.get(m-1).size();
        if (n == 0 || m != n) {
            return 0;
        }

        // 初始化结果的存储位置
        int[][] res = new int[m][m];
        // 初始化最后一行结果
        List<Integer> lastList = triangle.get(m - 1);
        for (int i = 0; i < m; i++) {
            res[m - 1][i] = lastList.get(i);
        }
        for (int i = m - 2; i >= 0; i--) {
            List<Integer> currentList = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                res[i][j] = Math.min(res[i + 1][j], res[i + 1][j + 1]) + currentList.get(j);
            }
        }
        return res[0][0];
    }
}
