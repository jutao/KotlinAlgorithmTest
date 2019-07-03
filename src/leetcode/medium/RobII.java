package leetcode.medium;

/**
 * author：jutao
 * time：2019/7/3
 * description：213. 打家劫舍 II
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
 * 这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，
 * 相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统
 * 会自动报警。给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置
 * 的情况下，能够偷窃到的最高金额。
 */
public class RobII {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int[] memory1 = new int[nums.length];
        int[] memory2 = new int[nums.length];
        //从0号开始偷
        memory1[1] = nums[0];
        //从1号开始偷
        memory2[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            memory1[i] = Math.max(nums[i-1] + memory1[i - 2], memory1[i - 1]);
            memory2[i] = Math.max(nums[i] + memory2[i - 2], memory2[i - 1]);
        }
        return Math.max(memory1[memory1.length-1],memory2[memory2.length-1]);
    }

    //    public int rob(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        if (nums.length == 1) {
//            return nums[0];
//        }
//        if (nums.length == 2) {
//            return Math.max(nums[0], nums[1]);
//        }
//        int[] memory = new int[nums.length];
//        memory[0] = nums[0];
//        memory[1] = Math.max(nums[0], nums[1]);
//        for (int i = 2; i < nums.length - 1; i++) {
//            memory[i] = Math.max(nums[i] + memory[i - 2], memory[i - 1]);
//        }
//        int res = memory[nums.length - 2];
//        memory[1] = nums[1];
//        memory[2] = Math.max(nums[1], nums[2]);
//        for (int i = 3; i < nums.length; i++) {
//            memory[i] = Math.max(nums[i] + memory[i - 2], memory[i - 1]);
//        }
//        res = Math.max(memory[memory.length - 1], res);
//        return res;
//    }
}
