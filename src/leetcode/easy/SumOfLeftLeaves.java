package easy;

/**
 * ****************************************
 * author：琚涛
 * time：2019/4/12
 * description：404. 左叶子之和
 * 计算给定二叉树的所有左叶子之和。
 * ****************************************
 */
public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null){
            return 0;
        }
        return leftVal(root,false);
    }

    int leftVal(TreeNode root,boolean isLeft){
        if(root==null){
            return 0;
        }
        if(isLeft&&root.left==null&&root.right==null){
            return root.val;
        }else {
            return leftVal(root.left,true)+leftVal(root.right,false);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
