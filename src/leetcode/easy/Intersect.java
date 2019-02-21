package leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 350. 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 * <p>
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 */
public class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        for (int i = 0; i < nums1.length; i++) {
            if (map.get(nums1[i]) == null) {
                map.put(nums1[i], 1);
            } else {
                map.put(nums1[i], map.get(nums1[i]) + 1);
            }
        }
        for (int num : nums2) {
            if (map.get(num) != null && map.get(num) != 0) {
                map.put(num, map.get(num) - 1);
                res.add(num);
            }

        }
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}
