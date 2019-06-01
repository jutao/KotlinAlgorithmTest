package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. 子集 II
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 */
public class SubsetsWithDup {

    public static void main(String[] args) {
        System.out.println(new SubsetsWithDup().subsetsWithDup(new int[]{4,4,4,1,4}));
    }

    List<List<Integer>> res;
    List<Integer> temp;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        temp = new ArrayList<>();
        Arrays.sort(nums);
        subsets(nums, 0);
        return res;
    }

    private void subsets(int[] nums, int start) {
        res.add(new ArrayList<>(temp));
        if (start == nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if(start<i&&nums[i]==nums[i-1]){
                continue;
            }
            temp.add(nums[i]);
            subsets(nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

}
