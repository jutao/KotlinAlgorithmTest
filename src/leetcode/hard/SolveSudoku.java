package leetcode.hard;

/**
 * author：jutao
 * time：2019/6/19
 * description：37. 解数独
 * 编写一个程序，通过已填充的空格来解决数独问题。
 * <p>
 * 一个数独的解法需遵循如下规则：
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 */
public class SolveSudoku {
    public static void main(String[] args) {
        char[][] board = {
                {'5', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '1', '.', '.', '.', '.', '.'},
                {'3', '.', '.', '2', '.', '.', '.', '.', '4'},
                {'.', '.', '.', '3', '.', '.', '1', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '7', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '6', '.', '.', '.', '.', '.'},
                {'8', '.', '.', '5', '.', '.', '6', '.', '.'},
                {'.', '1', '.', '4', '.', '.', '.', '.', '9'}};
        new SolveSudoku().solveSudoku(board);
        for (char[] chars : board) {
            for (char aChar : chars) {
                System.out.print("  "+aChar+"  ");
            }
            System.out.println();
        }
    }

    final int N = 9;

    public void solveSudoku(char[][] board) {
        if (board == null) {
            return;
        }
        if (board.length != N) {
            return;
        }
        if (board[0].length != N) {
            return;
        }
        //横坐标代表行号[0,8],纵坐标代表哪些数字被使用[0,8]
        boolean[][] row = new boolean[board.length][board.length];
        //横坐标代表列号[0,8],纵坐标代表哪些数字被使用[0,8]
        boolean[][] col = new boolean[board.length][board.length];
        //横坐标代表box号[0,8],纵坐标代表哪些数字被使用[0,8](box=x/3*3+y/3)
        boolean[][] box = new boolean[board.length][board.length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                row[i][board[i][j] - '0' - 1] = true;
                col[j][board[i][j] - '0' - 1] = true;
                box[i / 3 * 3 + j / 3][board[i][j] - '0' - 1] = true;
            }
        }
        dfs(0, 0, row, col, box, board);
    }

    private boolean dfs(int i, int j, boolean[][] row, boolean[][] col, boolean[][] box, char[][] board) {
        while (board[i][j] != '.') {
            if (++j >= board[i].length) {
                j = 0;
                i++;
            }
            if (i >= board.length) {
                return true;
            }
        }
        for (int k = 1; k <= 9; k++) {
            if (!row[i][k - 1] && !col[j][k - 1] && !box[i / 3 * 3 + j / 3][k - 1]) {
                row[i][k - 1] = true;
                col[j][k - 1] = true;
                box[i / 3 * 3 + j / 3][k - 1] = true;
                board[i][j] = (char) (k + '0');
                if (dfs(i, j, row, col, box, board)) {
                    return true;
                }
                row[i][k - 1] = false;
                col[j][k - 1] = false;
                box[i / 3 * 3 + j / 3][k - 1] = false;
                board[i][j] = '.';
            }
        }
        return false;
    }
}
