package easy;

/**
 * ****************************************
 * author：琚涛
 * time：2019/1/25
 * description：35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * ****************************************
 */
public class SearchInsert {
    public static void main(String[] args) {
        int[] a={1};
        System.out.println(new SearchInsert().searchInsert(a, 1));
    }
    public int searchInsert(int[] nums, int target) {
        if (nums[0] >= target) {
            return 0;
        }
        if(nums[nums.length - 1] == target){
            return nums.length - 1;
        }
        if (nums[nums.length - 1] < target) {
            return nums.length;
        }
        int l=0;
        int r=nums.length-1;
        while (l<=r){
            int m=l+(r-l)/2;
            if(nums[m]>=target&&nums[m-1]<target){
                return m;
            }else if(nums[m]<target){
                l=m+1;
            }else {
                r=m-1;
            }
        }
        return -1;
    }
}
