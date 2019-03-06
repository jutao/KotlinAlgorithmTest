package easy;

import java.util.HashMap;
import java.util.Stack;

/**
 * ****************************************
 * author：琚涛
 * time：2019/3/4
 * description：496. 下一个更大元素 I
 * 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * <p>
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。
 * 注意:
 * <p>
 * nums1和nums2中所有元素是唯一的。
 * nums1和nums2 的数组大小都不超过1000。
 * ****************************************
 */
public class NextGreaterElement {
    public static void main(String[] args) {
        new NextGreaterElement().nextGreaterElement(new int[]{1, 4, 2}, new int[]{1, 3, 4, 2, 22, 8});
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                hashMap.put(stack.pop(), num);
            }
            stack.push(num);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i]=hashMap.getOrDefault(nums1[i],-1);
        }
        return nums1;
    }
}
