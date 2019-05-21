package leetcode.medium;

/**
 * author：jutao
 * time：2019/5/20
 * description：450. 删除二叉搜索树中的节点
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 *
 * 一般来说，删除节点可分为两个步骤：
 *
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
 */
public class DeleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return null;
        }
        if(key<root.val){
            root.left=deleteNode(root.left,key);
        }else if(key>root.val){
            root.right=deleteNode(root.right,key);
        }else {
            if (root.right==null){
                return root.left;
            }
            if (root.left==null){
                return root.right;
            }
            root.val=getMinValue(root.right).val;
            root.right=deleteNode(root.right,root.val);
        }
        return root;
    }

    private TreeNode getMinValue(TreeNode root) {
        if(root.left==null){
            return root;
        }
        root=getMinValue(root.left);
        return root;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}