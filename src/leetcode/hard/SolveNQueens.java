package leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author：jutao
 * time：2019/6/18
 * description：51. N皇后
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 */
public class SolveNQueens {
    public static void main(String[] args) {
        List<List<String>> lists = new SolveNQueens().solveNQueens(4);
        for (List<String> list : lists) {
            for (String s : list) {
                for (char c : s.toCharArray()) {
                    System.out.print("  "+c+"  ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }


    /**
     * 哪一列是否被占用
     */
    boolean[] col;
    /**
     * 从左往右对角线是否被占用
     */
    boolean[] diagonalLeft;
    /**
     * 从右往左对角线是否被占用
     */
    boolean[] diagonalRight;
    List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        col = new boolean[n];
        diagonalLeft = new boolean[2 * n - 1];
        diagonalRight = new boolean[2 * n - 1];
        dfs(0, n, new String[n]);
        return res;
    }

    private void dfs(int i, int n, String[] lines) {
        if (i >= n) {
            res.add(new ArrayList<>(Arrays.asList(lines)));
            return;
        }
        for (int j = 0; j < n; j++) {
            if (!col[j] && !diagonalLeft[i - j + n - 1] && !diagonalRight[i + j]) {
                char[] line = new char[n];
                Arrays.fill(line, '.');
                line[j]='Q';
                lines[i]=new String(line);
                col[j]=diagonalLeft[i - j + n - 1]=diagonalRight[i + j]=true;
                dfs(i+1,n,lines);
                col[j]=diagonalLeft[i - j + n - 1]=diagonalRight[i + j]=false;
            }
        }
    }
}
