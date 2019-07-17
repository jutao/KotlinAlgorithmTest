package leetcode.backpack;

/**
 * author：jutao
 * time：2019/7/17
 * description：01背包问题
 * 有N件物品和一个容量为V的背包。第i件物品的费用是c[i]，价值是w[i]。求解将哪些物品装入背包可使价值总和最大。
 */
public class Knap01 {
    public static void main(String[] args) {
        int[] w = {11, 12, 13, 14, 15};
        int[] v = {9, 23, 7, 22, 25};
        int index = w.length;
        int c = 28;
        System.out.println(new Knap01().bestValue(w, v, index, c));
    }

    /**
     * 用 [0...index]的物品,填充容积为c的背包的最大价值
     *
     * @param w     重量数组
     * @param v     价值
     * @param index 物品数量
     * @param c     背包总容量
     * @return 最大价值
     */
    private int bestValue(int[] w, int[] v, int index, int c) {
        assert (w.length == v.length && c >= 0);
        int[][] memory = new int[index][c + 1];

        for (int i = 0; i <= c; i++) {
            memory[0][i] = i >= w[0] ? v[0] : 0;
        }
        for (int i = 1; i < index; i++) {
            for (int j = 0; j <= c; j++) {
                if (j >= w[i]) {
                    memory[i][j] = Math.max(memory[i - 1][j], v[i] + memory[i - 1][j - w[i]]);
                }
            }
        }
        return memory[index - 1][c - 1];
    }
}
