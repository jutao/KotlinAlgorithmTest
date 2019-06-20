package leetcode.medium;

/**
 * author：jutao
 * time：2019/6/20
 * description：64. 最小路径和
 * tag:动态规划
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 */
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        if(grid==null){
            return -1;
        }
        int row=grid.length;
        int col=grid[0].length;
        if(col==0){
            return -1;
        }
        for (int i = 1; i < col; i++) {
            grid[0][i]=grid[0][i]+grid[0][i-1];
        }
        for (int i = 1; i < row; i++) {
            grid[i][0]=grid[i][0]+grid[i-1][0];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                grid[i][j]=grid[i][j]+Math.min(grid[i-1][j],grid[i][j-1]);
            }
        }
        return grid[row-1][col-1];
    }
}
