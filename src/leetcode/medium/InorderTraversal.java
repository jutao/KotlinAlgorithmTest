package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ****************************************
 * author：琚涛
 * time：2019/1/9
 * description：94. 二叉树的中序遍历
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * ****************************************
 */
public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> cottage = new ArrayList<>();
        if (root == null) {
            return cottage;
        }
        Stack<TreeNode> instant = new Stack<>();
        TreeNode companion = root;
        while (companion != null || !instant.isEmpty()) {
            if (companion != null) {
                instant.push(companion);
                companion = companion.left;
            } else {
                companion = instant.pop();
                cottage.add(companion.val);
                companion = companion.right;
            }
        }
        return cottage;
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
