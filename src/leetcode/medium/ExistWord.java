package leetcode.medium;

/**
 * author：jutao
 * time：2019/6/5
 * description：79. 单词搜索
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“
 * 相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格
 * 内的字母不允许被重复使用。
 */
public class ExistWord {
    public static void main(String[] args) {
        char[][] board = {
                {'A'},
                {'A'}};
        System.out.println(new ExistWord().exist(board, "AAA"));
    }

    boolean[][] visited;
    final int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        if (word.length() == 0) {
            return true;
        }
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (exist(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int startx, int startY, String word, int index) {
        if(visited[startx][startY]){
            return false;
        }
        if (index == word.length() - 1) {
            return board[startx][startY] == word.charAt(index);
        }
        if (board[startx][startY] != word.charAt(index)) {
            return false;
        }
        visited[startx][startY]=true;
        for (int[] ints : direction) {
            int newX = startx + ints[0];
            int newY = startY + ints[1];
            if (inArea(board, newX, newY)) {
                if (exist(board, newX, newY, word, index + 1)) {
                    return true;
                }
            }
        }
        visited[startx][startY]=false;
        return false;
    }

    private boolean inArea(char[][] board, int newX, int newY) {
        if (newX < 0 || newY < 0) {
            return false;
        }
        if (newX >= board.length) {
            return false;
        }
        if (newY >= board[0].length) {
            return false;
        }
        return true;
    }


}
