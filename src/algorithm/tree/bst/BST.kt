package sort.algorithm.tree.bst


/**
 * 二分搜索树
 */
class BST<K,V> {
    private var root: Node? = null
    private var count = 0

    val isEmpty: Boolean
        get() = count == 0

    fun size(): Int {
        return count
    }


    /**
     * 插入值到搜索树，递归写法
     */
    fun insertRecursion(value: Int) {
        root = insertRecursion(root, value)
    }

    private fun insertRecursion(node: Node?, value: Int): Node {
        if (node == null) {
            count++
            return Node(value)
        }
        if (node.value == value) {
            node.value = value
        } else if (node.value > value) {
            node.left = insertRecursion(node.left, value)
        } else {
            node.right = insertRecursion(node.right, value)
        }
        return node
    }


    /**
     * 插入一个值到搜索树普通写法
     */
    fun insertNormal(value: Int) {
        if (root == null) {
            count++
            root = Node(value)
            return
        }
        //当前元素父元素
        var parentNode = root
        //当前元素
        var currentNode = root
        while (currentNode != null) {
            if (currentNode.value == value) {
                currentNode.value = value
                return
            }
            parentNode = currentNode
            currentNode = if (value < currentNode.value) {
                currentNode.left
            } else {
                currentNode.right
            }
        }
        if (value < parentNode!!.value) {
            parentNode.left = Node(value)
        } else {
            parentNode.right = Node(value)
        }
        count++
    }

    /**
     * 树中是否包含该value
     */
    fun contain(value: Int): Boolean {
        return contain(root, value)
    }

    /**
     * 以 node 为根的二叉搜索树中是否包含value节点
     */
    private fun contain(node: Node?, value: Int): Boolean {
        if (node == null) {
            return false
        }
        if (value == node.value) {
            return true
        }
        return if (value < node.value) {
            contain(node.left, value)
        } else {
            contain(node.right, value)
        }
    }

    fun search(value:Int):Int{

    }

    /**
     * 二分搜索树节点
     */
    internal class Node(var value: Int) {
        var left: Node? = null
        var right: Node? = null

    }
}