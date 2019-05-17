package leetcode.easy;

/**
 * author：jutao
 * time：2019/5/17
 * description：437. 路径总和 III
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * <p>
 * 找出路径和等于给定数值的路径总数。
 * <p>
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * <p>
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 */
public class PathSumThree {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int res = findPathSum(root, sum);
        res+=pathSum(root.left,sum);
        res+=pathSum(root.right,sum);
        return res;
    }

    private int findPathSum(TreeNode root, int sum) {
        if(root==null){
            return 0;
        }
        int res = 0;
        if (root.val == sum) {
            res++;
        }
        res+=findPathSum(root.left,sum-root.val);
        res+=findPathSum(root.right,sum-root.val);
        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
