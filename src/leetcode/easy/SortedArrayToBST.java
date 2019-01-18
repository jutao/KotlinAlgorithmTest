package easy;

/**
 * ****************************************
 * author：琚涛
 * time：2019/1/8
 * description：
 * ****************************************
 */
public class SortedArrayToBST {
    public  TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0){
            return null;
        }
        int middle = nums.length / 2;
        TreeNode root = new TreeNode(nums[middle]);
        TreeNode currentLeftNode = root;
        TreeNode currentRightNode = root;

        for (int i = 0; i < middle; i++) {
            if ((middle - 1 - i) >=0) {
                currentLeftNode.left = new TreeNode(nums[middle - 1 - i]);
                currentLeftNode = currentLeftNode.left;
            }
            if ((middle + 1 + i) < nums.length) {
                currentRightNode.right = new TreeNode(nums[middle + 1 + i]);
                currentRightNode = currentRightNode.right;
            }

        }

        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
