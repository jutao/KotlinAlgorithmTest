package leetcode.medium;

/**
 * 209. 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 * <p>
 * 示例:
 * <p>
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 */
public class MinSubArrayLen {
    public static void main(String[] args) {
        new MinSubArrayLen().minSubArrayLen(7,new int[]{2,3,1,2,4,3});
    }
    public int minSubArrayLen(int s, int[] nums) {
        int l = 0;
        int r = -1;
        int sum = 0;
        int res = nums.length + 1;

        while (l < nums.length) {
            if (r+1<nums.length&&sum <= s) {
                sum += nums[++r];
            } else {
                sum -= nums[l++];
            }
            if (sum>=s){
                res=Math.min(res,r-l+1);
            }
        }

        if (res == nums.length + 1) {
            return 0;
        }
        return res;
    }
}
