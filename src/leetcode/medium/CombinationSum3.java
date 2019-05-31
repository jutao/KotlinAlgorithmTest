package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author：jutao
 * time：2019/5/31
 * description：216. 组合总和 III
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 */
public class CombinationSum3 {
    public static void main(String[] args) {
        System.out.println(new CombinationSum3().combinationSum3(3, 33));
    }

    List<List<Integer>> res;
    List<Integer> temp;

    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        temp = new ArrayList<>();
        combinationSum(k, n, 1);
        return res;
    }

    private void combinationSum(int k, int target, int start) {
        if (target == 0) {
            if(temp.size()<k){
                return;
            }
            res.add(new ArrayList<>(temp));
            return;
        }
        if (temp.size() == k) {
            return;
        }
        for (int i = start; i <= 9; i++) {
            if(target<i){
                return;
            }
            temp.add(i);
            combinationSum(k,target-i,i+1);
            temp.remove(temp.size()-1);
        }
    }

}
