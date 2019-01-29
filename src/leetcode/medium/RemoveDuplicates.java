package medium;

/**
 * ****************************************
 * author：琚涛
 * time：2019/1/29
 * description：80. 删除排序数组中的重复项 II
 * <p>
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例 1:
 * <p>
 * 给定 nums = [1,1,1,2,2,3],
 * <p>
 * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 * <p>
 * 给定 nums = [0,0,1,1,1,1,2,3,3],
 * <p>
 * 函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * ****************************************
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        removeDuplicates(new int[]{1,1,1,2,2,3});
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int j = 2;
        for (int i =2; i < nums.length; i++) {
            if (nums[i] != nums[j- 2]) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}
