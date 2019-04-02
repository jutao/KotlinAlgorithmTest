package easy;

import java.util.*;

/**
 * ****************************************
 * author：琚涛
 * time：2019/4/2
 * description：107. 二叉树的层次遍历 II
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * ****************************************
 */
public class LevelOrderBottom {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(22);
        root.left=new TreeNode(11);
        root.left.left=new TreeNode(9);
        root.left.right=new TreeNode(12);
        root.right=new TreeNode(23);
        root.right.left=new TreeNode(21);
        root.right.right=new TreeNode(30);
        root.right.right.left=new TreeNode(15);
        root.right.right.right=new TreeNode(35);
        List<List<Integer>> lists = new LevelOrderBottom().levelOrderBottom(root);
        System.out.println(lists);
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if(root==null){
            return res;
        }

        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> list=new ArrayList<>();
            int count=queue.size();
            while (count>0){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
                count--;
            }
            res.addFirst(list);
        }
        return res;
    }
      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }
}
