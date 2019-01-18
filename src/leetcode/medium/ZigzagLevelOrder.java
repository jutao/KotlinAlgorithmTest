package medium;

import javafx.util.Pair;

import java.util.*;

/**
 * ****************************************
 * author：琚涛
 * time：2019/1/18
 * description：
 * ****************************************
 */
public class ZigzagLevelOrder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, 0));
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> pair = stack.pop();
            int hierarchy = pair.getValue();
            TreeNode tree = pair.getKey();
            if (lists.size() <= hierarchy) {
                lists.add(new ArrayList<>());
            }
            if(hierarchy%2==0){
                lists.get(hierarchy).add(0,tree.val);
            }else {
                lists.get(hierarchy).add(tree.val);
            }

            if(tree.left!=null){
                stack.push(new Pair<>(tree.left,hierarchy+1));
            }
            if(tree.right!=null){
                stack.push(new Pair<>(tree.right,hierarchy+1));
            }

        }
        return lists;
    }
}
