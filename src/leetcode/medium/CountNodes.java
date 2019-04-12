package medium;

/**
 * ****************************************
 * author：琚涛
 * time：2019/4/10
 * description：222. 完全二叉树的节点个数
 * 给出一个完全二叉树，求出该树的节点个数。
 * ****************************************
 */
public class CountNodes {
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftCount=countNodes(root.left);
        int rightCount=countNodes(root.right);
        return leftCount+rightCount+1;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
