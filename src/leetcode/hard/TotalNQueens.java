package leetcode.hard;

/**
 * author：jutao
 * time：2019/6/18
 * description：52. N皇后 II
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 */
public class TotalNQueens {
    public static void main(String[] args) {
        System.out.println(new TotalNQueens().totalNQueens(5));
    }

    private int size;
    private int count;

    private void solve(int row, int ld, int rd) {
        if (row == size) {
            count++;
            return;
        }
        int pos = size & (~(row | ld | rd));
        while (pos != 0) {
            int p = pos & (-pos);
            pos -= p; // pos &= pos - 1;
            solve(row | p, (ld | p) << 1, (rd | p) >> 1);
        }
    }

    public int totalNQueens(int n) {
        count = 0;
        size = (1 << n) - 1;
        solve(0, 0, 0);
        return count;
    }
}
