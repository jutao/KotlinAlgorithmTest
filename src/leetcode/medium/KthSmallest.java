package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * author：jutao
 * time：2019/5/21
 * description：230. 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * <p>
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 */
public class KthSmallest {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list=new ArrayList<>();
        calculateList(root,list);
        return list.get(k-1);
    }

    private void calculateList(TreeNode root, List<Integer> list) {
        if(root==null){
            return;
        }
        calculateList(root.left,list);
        list.add(root.val);
        calculateList(root.right,list);
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
