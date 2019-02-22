package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ****************************************
 * author：琚涛
 * time：2019/2/21
 * description：15. 三数之和
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * ****************************************
 */
public class ThreeSum {
    public static void main(String[] args) {
        new ThreeSum().threeSum(new int[]{-2, 0, 0, 2, 2});
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        if (nums[0] > 0) {
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            int sum = -nums[i];
            while (l < r) {
                if (nums[l] + nums[r] == sum) {
                    List<Integer> list = new ArrayList();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    result.add(list);
                    l++;
                    r--;
                    while (l < r && nums[l - 1] == nums[l] && nums[r + 1] == nums[r]) {
                        l++;
                        r--;
                    }
                } else if (nums[l] + nums[r] > sum) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return result;
    }
}
