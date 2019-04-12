package easy;

/**
 * ****************************************
 * author：琚涛
 * time：2019/4/12
 * description：112. 路径总和
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 说明: 叶子节点是指没有子节点的节点。
 * ****************************************
 */
public class HasPathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        if(root.left==null&&root.right==null){
            return root.val==sum;
        }
        if(hasPathSum(root.left,sum-root.val)){
            return true;
        }
        if(hasPathSum(root.right,sum-root.val)){
            return true;
        }
        return false;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
