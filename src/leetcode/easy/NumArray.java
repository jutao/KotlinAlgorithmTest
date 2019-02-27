package easy;

/**
 * ****************************************
 * author：琚涛
 * time：2019/2/26
 * description：303. 区域和检索 - 数组不可变
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 * <p>
 * 示例：
 * <p>
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 * <p>
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * 说明:
 * <p>
 * 你可以假设数组不可变。
 * 会多次调用 sumRange 方法。
 * ****************************************
 */
public class NumArray {
    private int[] step;

    public NumArray(int[] nums) {
        int[] step = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i != 0) {
                step[i] = step[i - 1] + nums[i];
            } else {
                step[i] = nums[i];
            }
        }
        this.step = step;
    }

    public int sumRange(int i, int j) {
        if (i >= step.length || j >= step.length || i < 0 || j < 0) {
            return 0;
        }
        if (i == 0) {
            return step[j];
        } else {
            return step[j] - step[i - 1];
        }
    }
}
