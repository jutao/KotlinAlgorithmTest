package medium;

/**
 * ****************************************
 * author：琚涛
 * time：2019/3/7
 * description：220. 存在重复元素 III
 * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，
 * 使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
 * ****************************************
 */
public class ContainsNearbyAlmostDuplicate {
    public static void main(String[] args) {
        System.out.println(new ContainsNearbyAlmostDuplicate().containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0));
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //滑动窗口解法
        if (k <= 0) {
            return false;
        }
        int len = nums.length;
        int end = 1;
        int start = 0;
        while (start < len - 1) {
            if (start <= end && Math.abs(Long.valueOf(nums[end] - Long.valueOf(nums[start]))) <= t) {
                return true;
            }
            if (end - start == k || end + 1 == len) {
                start++;
                if (t != 0) {
                    end = start + 1;
                }
            } else {
                end++;
            }
        }
        return false;
    }
}
