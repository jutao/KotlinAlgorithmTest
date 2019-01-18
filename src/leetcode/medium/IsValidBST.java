package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ****************************************
 * author：琚涛
 * time：2019/1/11
 * description：98. 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * ****************************************
 */
public class IsValidBST {
    public  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public  boolean isValidBST(TreeNode root) {
        List<Integer> list = inorderTraversal(root);
        for (int i = 1; i < list.size(); i++) {
            if(list.get(i)<=list.get(i-1)){
                return false;
            }
        }
        return true;
    }
    public  List<Integer> inorderTraversal(TreeNode root) {
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

}
