package medium;

import java.util.Arrays;

/**
 * ****************************************
 * author：琚涛
 * time：2018/9/28
 * description：给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，
 * 使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * ****************************************
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        new ThreeSumClosest().threeSumClosest(new int[]{1,2,5,10,11},12);
    }
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length <= 3) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            return sum;
        }
        Arrays.sort(nums);
        if (nums[0] > target&&target>0) {
            return nums[0] + nums[1] + nums[2];
        }
        int minPos = Integer.MAX_VALUE - Math.abs(target);
        int res = minPos;
        for (int i = 0; i < nums.length; i++) {
            int purpose=target-nums[i];
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[l] + nums[r] + nums[i];
                int pos = Math.abs(sum-target);
                if (pos == 0) {
                    return sum;
                }
                if (pos < minPos) {
                    minPos = pos;
                    res = sum;
                }
                if (nums[l]+nums[r]>purpose) {
                    r--;
                }else {
                    l++;
                }
            }
        }
        return res;
    }
}
