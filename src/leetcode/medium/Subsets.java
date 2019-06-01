package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 */
public class Subsets {
    public static void main(String[] args) {
        System.out.println(new Subsets().subsets(new int[]{1, 2, 3}));
    }

    List<List<Integer>> res;
    List<Integer> temp;

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        temp = new ArrayList<>();
        subsets(nums, 0);
        return res;
    }

    private void subsets(int[] nums, int start) {
        res.add(new ArrayList<>(temp));
        if (start == nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            subsets(nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
