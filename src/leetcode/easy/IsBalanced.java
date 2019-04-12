package easy;

/**
 * ****************************************
 * author：琚涛
 * time：2019/4/10
 * description：110. 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * ****************************************
 */
public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        boolean left=isBalanced(root.left);
        boolean right=isBalanced(root.right);
        return left&&right&&Math.abs(countNodes(root.left)-countNodes(root.right))<=1;
    }

    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftCount=countNodes(root.left);
        int rightCount=countNodes(root.right);
        return Math.max(leftCount,rightCount)+1;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
