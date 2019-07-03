package leetcode.easy;

/**
 * ****************************************
 * author：琚涛
 * time：2019/2/26
 * description：198. 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 * <p>
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * ****************************************
 */
public class Rob {
    public static void main(String[] args) {
        System.out.println(new Rob().rob(new int[]{1,3,1,3,100}));
    }

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        int[] memo = new int[nums.length];
        memo[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >=0; i--) {
            if (i + 2 >= nums.length) {
                memo[i] = nums[i];
            } else if (i + 3 >= nums.length) {
                memo[i] = nums[i] + memo[i + 2];
            }else {
                memo[i]=nums[i]+Math.max(memo[i + 2],memo[i + 3]);
            }
        }
        return Math.max(memo[0],memo[1]);
    }

}
