package easy;

/**
 * ****************************************
 * author：琚涛
 * time：2019/4/3
 * description：747. 至少是其他数字两倍的最大数
 * 在一个给定的数组nums中，总是存在一个最大元素 。查找数组中的最大元素是否至少是数组中每个其他数字的两倍。如果是，则返回最大元素的索引，否则返回-1。
 * ****************************************
 */
public class DominantIndex {
    public int dominantIndex(int[] nums) {
        int max=-1;
        int max2=-1;
        int maxIndex=-1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>=max){
                if(nums[i]==max){
                    continue;
                }
                max2=max;
                max=nums[i];
                maxIndex=i;
            }else if(nums[i]>max2){
                max2=nums[i];
            }
        }
        if(max2*2>max){
            return -1;
        }
        return maxIndex;
    }
}
