package medium;

/**
 * ****************************************
 * author：琚涛
 * time：2019/2/26
 * description：152. 乘积最大子序列
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 * ****************************************
 */
public class MaxProduct {
    public static void main(String[] args) {
        System.out.println(new MaxProduct().maxProduct(new int[]{2,-5,-2,-4,3}));
    }

    public int maxProduct(int[] nums) {
        int maxProduct = nums[0];

        int maxNav = nums[0];
        int minNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1]==0?nums[i]:nums[i - 1] * nums[i];
            int productsMinNum=minNum==0?0:nums[i]/minNum;
            int productsMaxNav=maxNav==0?0:nums[i]/maxNav;
            maxProduct = Math.max(maxProduct,Math.max(Math.max(nums[i],productsMinNum),productsMaxNav));
            if (nums[i] < 0) {
                if (maxNav >=0) {
                    maxNav = nums[i];
                } else {
                    if (maxNav < nums[i]) {
                        maxNav = nums[i];
                    }
                }
            } else if (nums[i] > 0 && nums[i] < minNum) {
                minNum = nums[i];
            }else if(nums[i]==0){
                minNum=maxNav=0;
            }
        }
        return maxProduct;
    }
}
