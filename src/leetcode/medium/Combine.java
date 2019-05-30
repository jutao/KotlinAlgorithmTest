package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * author：jutao
 * time：2019/5/30
 * description：77.组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 */
public class Combine {
    public static void main(String[] args) {
        System.out.println(new Combine().combine(100, 2));
    }

    List<List<Integer>> res;
    List<Integer> temp;

    public List<List<Integer>> combine(int n, int k) {

        res = new ArrayList<>();
        temp=new ArrayList<>();
        combineRecursion(0, n, k);
        return res;
    }

    private void combineRecursion(int index, int n, int k) {
        if (temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = (temp.size() == 0 ? 1 : temp.get(temp.size() - 1) + 1); i <= n - k + index + 1; i++) {
            temp.add(i);
            combineRecursion(index + 1, n, k);
            temp.remove(temp.size() - 1);
        }
    }
}
