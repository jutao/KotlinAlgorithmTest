package leetcode.medium;

/**
 * author：jutao
 * time：2019/6/25
 * description：63. 不同路径 II
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <p>
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 */
public class UniquePathsWithObstacles {
    public static void main(String[] args) {
        int[][] obstacleGrid = {{1}, {0}};
        new UniquePathsWithObstacles().uniquePathsWithObstacles(obstacleGrid);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dps = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0]==1) {
                break;
            }
            dps[i][0]=1;
        }
        for (int i = 0; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i]==1) {
                break;
            }
            dps[0][i]=1;
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if(obstacleGrid[i][j]==1){
                    dps[i][j]=0;
                }else {
                    dps[i][j]=dps[i-1][j]+dps[i][j-1];
                }
            }
        }
        return dps[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
