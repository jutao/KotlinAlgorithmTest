package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * author：jutao
 * time：2019/5/16
 * description：129. 求根到叶子节点数字之和
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 * <p>
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 * <p>
 * 计算从根到叶子节点生成的所有数字之和。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class SumNumbers {
    int result=0;
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        sumNumbers(root, 0);
        return result;
    }

    private void sumNumbers(TreeNode root, int sum) {
        if(root==null){
            return;
        }
        sum=sum*10+root.val;
        if(root.left==null&&root.right==null){
            result+=sum;
        }else {
            sumNumbers(root.left,sum);
            sumNumbers(root.right,sum);
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
