package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * ****************************************
 * author：琚涛
 * time：2019/3/1
 * description：219. 存在重复元素 II
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 * ****************************************
 */
public class ContainsNearbyDuplicate {
    public static void main(String[] args) {
        System.out.println(new ContainsNearbyDuplicate().containsNearbyDuplicate(new int[]{1, 2, 1}, 1));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
           if(map.get(nums[i])==null){
               map.put(nums[i],i);
           }else {
               Integer l = map.get(nums[i]);
               if(i-l<=k){
                   return true;
               }
               map.put(nums[i],i);
           }
        }
        return false;
    }
}
