package leetcode.medium;

/**
 * author：jutao
 * time：2019/6/12
 * description：200. 岛屿数量
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，
 * 并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围
 */
public class NumIslands {

    public static void main(String[] args) {
        char[][] grid={
                {'1','1','0','1','0'},
                {'1','1','0','0','1'},
                {'0','0','1','0','0'},
                {'1','0','0','1','1'}};
        System.out.println(new NumIslands().numIslands(grid));

    }

    final int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    numIslands(grid, i, j);
                }
            }
        }
        return res;
    }

    private void numIslands(char[][] grid, int curX, int curY) {
        if (curX < 0 || curX >= grid.length) {
            return;
        }
        if (curY < 0 || curY >= grid[0].length) {
            return;
        }
        if (grid[curX][curY] != '1') {
            return;
        }
        grid[curX][curY] = '2';
        for (int[] ints : direction) {
            int newX = curX + ints[0];
            int newY = curY + ints[1];
            numIslands(grid, newX, newY);
        }
    }
}
