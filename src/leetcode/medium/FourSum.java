package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * ****************************************
 * author：琚涛
 * time：2019/2/22
 * description：18. 四数之和
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，
 * 判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * ****************************************
 */
public class FourSum {
    public static void main(String[] args) {
        List<List<Integer>> lists = new FourSum().fourSum(new int[]{1, -2, -5, -4, -3, 3, 3, 5}, -11);
        System.out.println(lists);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) {
            return Collections.emptyList();
        }
        List<List<Integer>> res = new ArrayList<>();


        Arrays.sort(nums);
        if (nums[0] > target&&target>=0) {
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            if(i>0){
                if(nums[i]==nums[i-1]){
                    continue;
                }
            }
            int sum = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if(j>i+1){
                    if(nums[j]==nums[j-1]){
                        continue;
                    }
                }
                int pos = sum - nums[j];
                int l = j + 1;
                int r = nums.length - 1;
                while (l < r) {
                    if (nums[l] + nums[r] == pos) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[l]);
                        temp.add(nums[r]);
                        res.add(temp);
                        l++;
                        r--;
                        while (l < r && nums[l] == nums[l - 1] && nums[r] == nums[r + 1]) {
                            l++;
                            r--;
                        }
                    } else if (nums[l] + nums[r] < pos) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }

        return res;
    }
}
