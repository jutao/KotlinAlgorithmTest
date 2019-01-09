package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * ****************************************
 * author：琚涛
 * time：2019/1/9
 * description：144. 二叉树的前序遍历
 * 给定一个二叉树，返回它的 前序 遍历。
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗
 * ****************************************
 */
public class PreorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

//    /**
//     * 迭代算法
//     * @param root
//     * @return
//     */
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        if (root == null) {
//            return list;
//        }
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//        while (!stack.isEmpty()) {
//            TreeNode temp = stack.pop();
//            list.add(temp.val);
//            if (temp.right != null) {
//                stack.push(temp.right);
//            }
//            if (temp.left != null) {
//                stack.push(temp.left);
//            }
//        }
//        return list;
//    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        preorderTraversal(root,list);
        return list;
    }

    private void preorderTraversal(TreeNode root, List<Integer> list) {
        if(root!=null){
            list.add(root.val);
            preorderTraversal(root.left,list);
            preorderTraversal(root.right,list);
        }
    }
}
