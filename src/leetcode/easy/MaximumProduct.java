package leetcode.easy;

import java.util.Arrays;

/**
 * author：jutao
 * time：2019/7/22
 * description：628. 三个数的最大乘积
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 */
public class MaximumProduct {
    public static void main(String[] args) {
        System.out.println(new MaximumProduct().maximumProduct(new int[]{-1, -2, -3,-4,-5,-6}));
    }

    public int maximumProduct(int[] nums) {
        if (nums.length <= 3) {
            int res = 1;
            for (int num : nums) {
                res *= num;
            }
            return res;
        }

        int[] max = new int[3];
        int[] min = new int[3];
        Arrays.fill(max,Integer.MIN_VALUE);
        Arrays.fill(min,Integer.MAX_VALUE);
        for (int num : nums) {
            maxArray(max, num);
            minArray(min, num);
        }
        return Math.max(max[0] * max[1] * max[2], max[0] * min[0] * min[1]);
    }

    private void minArray(int[] min, int num) {
        if (min[0] > num) {
            min[2] = min[1];
            min[1] = min[0];
            min[0] = num;
        } else if (min[1] > num) {
            min[2] = min[1];
            min[1] = num;
        } else if (min[2] > num) {
            min[2] = num;
        }
    }

    private void maxArray(int[] max, int num) {
        if (max[0] < num) {
            max[2] = max[1];
            max[1] = max[0];
            max[0] = num;
        } else if (max[1] < num) {
            max[2] = max[1];
            max[1] = num;
        } else if (max[2] < num) {
            max[2] = num;
        }
    }
}
