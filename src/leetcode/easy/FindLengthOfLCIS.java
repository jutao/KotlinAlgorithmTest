package easy;

/**
 * ****************************************
 * author：琚涛
 * time：2019/3/1
 * description：674. 最长连续递增序列
 * 给定一个未经排序的整数数组，找到最长且连续的的递增序列。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,4,7]
 * 输出: 3
 * 解释: 最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。
 * 示例 2:
 * <p>
 * 输入: [2,2,2,2,2]
 * 输出: 1
 * 解释: 最长连续递增序列是 [2], 长度为1。
 * ****************************************
 */
public class FindLengthOfLCIS {
    public static void main(String[] args) {
        System.out.println(new FindLengthOfLCIS().findLengthOfLCIS(new int[]{1, 2, 3, 4, 5}));
    }
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int max = 1;
        int temp = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                temp++;
            } else {
                max = Math.max(max, temp);
                temp = 1;
            }
        }
        max = Math.max(max, temp);
        return max;
    }
}
