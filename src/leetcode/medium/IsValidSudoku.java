package leetcode.medium;

/**
 * author：jutao
 * time：2019/6/19
 * description：36. 有效的数独
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 */
public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
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
                boolean[] box1 = box[i / 3 * 3 + j / 3];
                if (row[i][board[i][j] - '0' - 1] || col[j][board[i][j] - '0' - 1] || box1[board[i][j] - '0' - 1]) {
                    return false;
                }
                row[i][board[i][j] - '0' - 1] = true;
                col[j][board[i][j] - '0' - 1] = true;
                box1[board[i][j] - '0' - 1] = true;
            }
        }
        return true;
    }
}
