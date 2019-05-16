package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * author：jutao
 * time：2019/5/16
 * description：257. 二叉树的所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        binaryTreePaths(root, "", res);
        return res;
    }

    private void binaryTreePaths(TreeNode root, String cur, List<String> res) {
        if (root == null) {
            return;
        }
        cur += String.valueOf(root.val);
        if (root.left == null && root.right == null) {
            res.add(cur);
        }else {
            binaryTreePaths(root.left,cur+"->",res);
            binaryTreePaths(root.right,cur+"->",res);
        }
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
