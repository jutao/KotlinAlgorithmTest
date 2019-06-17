package leetcode.medium;

/**
 * author：jutao
 * time：2019/6/14
 * description：130. 被围绕的区域
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * <p>
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 */
public class Solve {
    public void solve(char[][] board) {
        if (board==null){
            return;
        }
        if (board.length==0) {
            return;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(i==0||i==board.length-1||j==0||j==board[i].length-1){
                    solve(i,j,board);
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j]=='-'){
                    board[i][j]='O';
                }
            }
        }
    }
    final int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private void solve(int curX, int curY, char[][] board) {
        if(curX<0||curX>=board.length){
            return;
        }
        if(curY<0||curY>=board[0].length){
            return;
        }
        if(board[curX][curY]!='O'){
            return;
        }
        board[curX][curY]='-';
        for (int[] ints : direction) {
            solve(ints[0]+curX,ints[1]+curY,board);
        }
    }
}
