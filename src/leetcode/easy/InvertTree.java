package easy;

/**
 * ****************************************
 * author：琚涛
 * time：2019/4/9
 * description：226. 翻转二叉树
 * 翻转一棵二叉树。
 * ****************************************
 */
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return root;
        }
        TreeNode node=root.left;
        root.left=invertTree(root.right);
        root.right=invertTree(node);
        return root;
    }


    public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
    }
}
