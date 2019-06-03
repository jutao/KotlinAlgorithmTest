package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * author：jutao
 * time：2019/6/3
 * description：501. 二叉搜索树中的众数
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 */
public class FindMode {
    List<Integer> res;
    TreeNode pre = null;
    int curTimes = 1;
    int maxTimes = 0;

    public int[] findMode(TreeNode root) {
        res = new ArrayList<>();
        foreach(root);
        int[] resInt = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resInt[i] = res.get(i);
        }
        return resInt;
    }

    private void foreach(TreeNode root) {
        if (root == null) {
            return;
        }
        foreach(root.left);
        if (pre != null) {
            curTimes = pre.val == root.val ? curTimes + 1 : 1;
        }
        if (curTimes == maxTimes) {
            res.add(root.val);
        } else if (curTimes > maxTimes) {
            res.clear();
            res.add(root.val);
            maxTimes = curTimes;
        }
        pre=root;
        foreach(root.right);
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
