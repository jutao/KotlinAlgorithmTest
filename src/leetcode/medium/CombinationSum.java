package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author：jutao
 * time：2019/5/31
 * description：39. 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 */
public class CombinationSum {
    public static void main(String[] args) {
        System.out.println(new CombinationSum().combinationSum(new int[]{1,2,3}, 7));
    }

    List<List<Integer>> res;
    List<Integer> temp;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        temp = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(candidates, target, 0);
        return res;
    }

    private void combinationSum(int[] candidates,int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) {
                return;
            }

            temp.add(candidates[i]);
            combinationSum(candidates,target - candidates[i], i);
            temp.remove(temp.size()-1);
        }
    }
}
