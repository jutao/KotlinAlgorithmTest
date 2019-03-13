package hard;

import java.util.Arrays;

/**
 * ****************************************
 * author：琚涛
 * time：2019/3/7
 * description：493. 翻转对
 * 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
 * 你需要返回给定数组中的重要翻转对的数量。
 * ****************************************
 */
// TODO: 2019/3/12 不够好
public class ReversePairs {
    public static void main(String[] args) {
        System.out.println(new ReversePairs().reversePairs(new int[]{1, 3, 2, 3, 1}));
    }

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int res = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);
        for (int i = left, j = mid + 1; i <= mid; i++) {
            while (j <= right && nums[i] / 2.0 > nums[j]) {
                ++j;
            }
            res += j - (mid + 1);
        }
        Arrays.sort(nums,left,right+1);
        return res;
    }
}
