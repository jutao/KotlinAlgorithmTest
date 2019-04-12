package easy;

/**
 * ****************************************
 * author：琚涛
 * time：2019/4/9
 * description：101. 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 * ****************************************
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode p, TreeNode q){
        if(p==null&&q==null){
            return true;
        }
        if(p==null||q==null){
            return false;
        }
        return (p.val==q.val)&&isMirror(p.left,q.right)&&isMirror(p.right,q.left);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
