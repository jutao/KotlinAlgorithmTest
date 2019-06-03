package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author：jutao
 * time：2019/5/31
 * description：40. 组合总和 II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 */
public class CombinationSum2 {
    public static void main(String[] args) {
        System.out.println(new CombinationSum2().combinationSum2(new int[]{1,1,4,6,8}, 9));
    }

    List<List<Integer>> res;
    List<Integer> temp;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            if(i>start&&candidates[i]==candidates[i-1]){
                continue;
            }
            temp.add(candidates[i]);
            combinationSum(candidates,target - candidates[i], i+1);
            temp.remove(temp.size()-1);
        }
    }

}
