package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * author：jutao
 * time：2019/6/17
 * description：417. 太平洋大西洋水流问题
 * 给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。
 * <p>
 * 规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。
 * <p>
 * 请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。
 */
public class PacificAtlantic {
    final int[][] direction = {{1}};

    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();

        if (matrix == null || matrix.length == 0) {
            return res;
        }
        boolean[][] visitedPacific = new boolean[matrix.length][matrix[0].length];
        boolean[][] visitedAtlantic = new boolean[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == 0 || j == 0) {
                    dfs(matrix, i, j, Integer.MIN_VALUE, visitedPacific);
                }
                if (i == matrix.length - 1 || j == matrix[i].length - 1) {
                    dfs(matrix, i, j, Integer.MIN_VALUE, visitedAtlantic);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (visitedAtlantic[i][j] && visitedPacific[i][j]) {
                    res.add(new int[]{i, j});
                }
            }
        }
        return res;
    }

    private void dfs(int[][] matrix, int curX, int curY, int lastValue, boolean[][] visited) {
        if (curX < 0 || curY < 0 || curX >= matrix.length || curY >= matrix[0].length || lastValue > matrix[curX][curY]||visited[curX][curY]) {
            return;
        }
        visited[curX][curY]=true;
        for (int[] ints : direction) {
            dfs(matrix,curX+ints[0],curY+ints[1],matrix[curX][curY],visited);
        }
    }

}
