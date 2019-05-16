package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * author：jutao
 * time：2019/5/16
 * description：113. 路径总和 II
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        pathSum(root, 0, res, sum, new ArrayList<>());
        return res;
    }

    private void pathSum(TreeNode root, int sum, List<List<Integer>> res, int target, List<Integer> temp) {
        if (root == null) {
            return;
        }
        sum = sum + root.val;
        temp.add(root.val);
        if (root.left == null && root.right == null && sum == target) {
            List<Integer> list = new ArrayList<>(temp);
            res.add(list);
        } else {
            pathSum(root.left, sum, res, target,temp);
            pathSum(root.right, sum, res, target,temp);
        }
        temp.remove(temp.size()-1);
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
