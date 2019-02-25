package hard;

import java.util.ArrayList;
import java.util.List;

/**
 * ****************************************
 * author：琚涛
 * time：2019/2/25
 * description：4. 寻找两个有序数组的中位数
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * ****************************************
 */
public class FindMedianSortedArrays {
    public static void main(String[] args) {
        System.out.println(new FindMedianSortedArrays().findMedianSortedArrays(new int[]{1, 3}, new int[]{}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        if (length == 0) {
            return 0;
        }
        boolean isDouble = length % 2 == 0;
        int i = 0;
        int j = 0;
        int sum = 1;
        List<Integer> list = new ArrayList<>();
        while (sum <= length / 2+1) {
            if (i >= nums1.length) {
                list.add(nums2[j++]);
            } else if (j >= nums2.length) {
                list.add(nums1[i++]);
            } else if (nums1[i] > nums2[j]) {
                list.add(nums2[j++]);
            } else list.add(nums1[i++]);
            sum++;
        }
        if (isDouble) {
            return (list.get(list.size() - 1) + list.get(list.size() - 2))/2.0;
        } else {
            return list.get(list.size() - 1);
        }
    }
}
