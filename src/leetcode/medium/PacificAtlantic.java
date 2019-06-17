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
    boolean[][] visited;
    final int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();

        if (matrix == null || matrix.length == 0) {
            return res;
        }
        visited = new boolean[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (pacific(matrix, i, j, Integer.MAX_VALUE) && atlantic(matrix, i, j, Integer.MAX_VALUE)) {
                    res.add(new int[]{i, j});
                }
            }
        }
        return res;
    }

    /**
     * 大西洋
     *
     * @param matrix
     * @param curX
     * @param curY
     * @param lastValue
     * @return
     */
    private boolean atlantic(int[][] matrix, int curX, int curY, int lastValue) {
        if (lastValue < matrix[curX][curY]) {
            return false;
        }
        if (visited[curX][curY]) {
            return false;
        }
        if (curX == matrix.length - 1 || curY == matrix[0].length - 1) {
            return true;
        }
        for (int[] ints : direction) {
            int newX = ints[0] + curX;
            int newY = ints[1] + curY;
            if(isInArea(newX,newY,matrix)){
                visited[curX][curY] = true;
                boolean res = atlantic(matrix, newX, newY, matrix[curX][curY]);
                visited[curX][curY] = false;
                if (res) {
                    return true;
                }
            }

        }
        return false;
    }

    /**
     * 太平洋
     *
     * @param matrix
     * @param curX
     * @param curY
     * @param lastValue
     * @return
     */
    private boolean pacific(int[][] matrix, int curX, int curY, int lastValue) {
        if (lastValue < matrix[curX][curY]) {
            return false;
        }
        if (visited[curX][curY]) {
            return false;
        }
        if (curX == 0 || curY == 0) {
            return true;
        }
        for (int[] ints : direction) {
            int newX = ints[0] + curX;
            int newY = ints[1] + curY;
            if(isInArea(newX,newY,matrix)){
                visited[curX][curY] = true;
                boolean res = pacific(matrix, newX, newY, matrix[curX][curY]);
                visited[curX][curY] = false;
                if (res) {
                    return true;
                }
            }

        }
        return false;
    }

    private boolean isInArea(int newX, int newY,int[][] matrix) {
        if (newX < 0 || newY < 0) {
            return false;
        }
        if (newX >= matrix.length || newY >= matrix[0].length) {
            return false;
        }
        return true;
    }

}
