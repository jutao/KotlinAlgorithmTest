package leetcode.easy;

/**
 * author：jutao
 * time：2019/5/17
 * description：485. 最大连续1的个数
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 */
public class FindMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int i = 0;
        int left = 0, right = 0;
        while (i < nums.length) {
            while (i < nums.length && nums[i] != 1) {
                i++;
            }
            left = i;
            while (i < nums.length && nums[i] == 1) {
                i++;
            }
            right = i;
            max = Math.max(max, right - left);
            i++;
        }
        return max;
    }
}
