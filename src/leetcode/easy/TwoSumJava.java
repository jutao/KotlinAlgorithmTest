package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * ****************************************
 * author：琚涛
 * time：2019/1/25
 * description：167. 两数之和 II - 输入有序数组
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * <p>
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * <p>
 * 说明:
 * <p>
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * ****************************************
 */
public class TwoSumJava {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>(numbers.length);
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i);
        }
        for (int i = 0; i < numbers.length; i++) {
            int a = target - numbers[i];
            if (map.get(a) != null) {
                int[] result = new int[]{Math.min(i, map.get(a)) + 1, Math.max(i, map.get(a)) + 1};
                return result;
            }
        }
        return null;
    }
}
