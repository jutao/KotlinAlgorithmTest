package easy;

/**
 * ****************************************
 * author：琚涛
 * time：2019/1/31
 * description：169. 求众数
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * ****************************************
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int count =1;
        int result=nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]==result){
                count++;
            }else {
                count--;
                if(count<0){
                    result=nums[i];
                    count=1;
                }
            }
        }
        return result;
    }
}
