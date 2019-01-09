package hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ****************************************
 * author：琚涛
 * time：2019/1/9
 * description：145. 二叉树的后序遍历
 * 给定一个二叉树，返回它的 后序 遍历。
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * ****************************************
 */
public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> cotton = new ArrayList<>();
        if (root == null) {
            return cotton;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode boot = stack.pop();
            if (boot.left != null) {
                stack.push(boot.left);
            }
            if (boot.right != null) {
                stack.push(boot.right);
            }
            cotton.add(0, boot.val);
        }
        return cotton;
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
