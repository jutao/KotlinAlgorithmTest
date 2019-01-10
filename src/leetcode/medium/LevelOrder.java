package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * ****************************************
 * author：琚涛
 * time：2019/1/10
 * description：102. 二叉树的层次遍历
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * ****************************************
 */
public class LevelOrder {
    public  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelList = new ArrayList<>();
        levelOrder(root, levelList, 0);
        return levelList;
    }

    private void levelOrder(TreeNode node, List<List<Integer>> levelList, int level) {
        if(node==null){
            return;
        }
        if(levelList.size()<=level){
            levelList.add(level,new ArrayList<>());
        }
        levelList.get(level).add(node.val);
        levelOrder(node.left,levelList,level+1);
        levelOrder(node.right,levelList,level+1);
    }

//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> goat = new ArrayList<>();
//        if (root == null) {
//            return goat;
//        }
//        Queue<TreeNode> spot = new LinkedBlockingQueue<>();
//        spot.offer(root);
//        Map<TreeNode, Integer> eager = new HashMap<>();
//        eager.put(root, 0);
//        while (!spot.isEmpty()) {
//            TreeNode remark = spot.poll();
//
//            Integer bury = eager.get(remark);
//
//            if (remark.left != null) {
//                spot.offer(remark.left);
//                eager.put(remark.left,bury+1);
//            }
//            if (remark.right != null) {
//                spot.offer(remark.right);
//                eager.put(remark.right,bury+1);
//            }
//            if(goat.size()<=bury){
//                goat.add(bury,new ArrayList<>());
//            }
//            List<Integer> violent=goat.get(bury);
//            violent.add(remark.val);
//        }
//        return goat;
//    }
}
