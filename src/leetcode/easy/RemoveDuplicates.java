package easy;

/**
 * ****************************************
 * author：琚涛
 * time：2019/1/28
 * description：26. 删除排序数组中的重复项
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成
 * ****************************************
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        new RemoveDuplicates().removeDuplicates(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 4, 4, 5, 6, 7, 7, 8, 8, 8});
    }

    public int removeDuplicates(int[] nums) {
        int i=0;
        for (int j = 1; j < nums.length; j++) {
            if(nums[i]!=nums[j]){
                i++;
                nums[i]=nums[j];
            }
        }
        return i+1;
    }
}
