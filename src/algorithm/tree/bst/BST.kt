package sort.algorithm.tree.bst

import java.util.*


/**
 * 二分搜索树
 */
fun main(args: Array<String>) {
    val bst: BST<String, Int> = BST()
    bst.insertNormal("za", 1)
    bst.insertNormal("b", 2)
    bst.insertNormal("c", 3)
    bst.insertRecursion("cc", 5)
    bst.insertNormal("bc", 6)
    bst.insertNormal("zzz", 7)
    bst.insertNormal("zzzc", 99)
    bst.insertNormal("zz", 8)
    bst.insertNormal("ac", 999)
    bst.remove("za")
    println(bst)
}

class BST<K : Comparable<K>, V> {
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
    fun insertRecursion(key: K, value: V) {
        root = insertRecursion(root, key, value)
    }

    private fun insertRecursion(node: Node?, key: K, value: V): Node {
        if (node == null) {
            count++
            return Node(key, value)
        }
        if (node.key == key) {
            //如果相等就覆盖
            node.value = value
        } else if (node.key > key) {
            node.left = insertRecursion(node.left, key, value)
        } else {
            node.right = insertRecursion(node.right, key, value)
        }
        return node
    }


    /**
     * 插入一个值到搜索树普通写法
     */
    fun insertNormal(key: K, value: V) {
        if (root == null) {
            count++
            root = Node(key, value)
            return
        }
        //当前元素父元素
        var parentNode = root
        //当前元素
        var currentNode = root
        while (currentNode != null) {
            if (currentNode.key == key) {
                currentNode.value = value
                return
            }
            parentNode = currentNode
            currentNode = if (key < currentNode.key) {
                currentNode.left
            } else {
                currentNode.right
            }
        }
        if (key < parentNode!!.key) {
            parentNode.left = Node(key, value)
        } else {
            parentNode.right = Node(key, value)
        }
        count++
    }

    /**
     * 树中是否包含该 key
     */
    fun contain(key: K): Boolean {
        return contain(root, key)
    }

    /**
     * 以 node 为根的二叉搜索树中是否包含key节点
     */
    private fun contain(node: Node?, key: K): Boolean {
        if (node == null) {
            return false
        }
        if (key == node.key) {
            return true
        }
        return if (key < node.key) {
            contain(node.left, key)
        } else {
            contain(node.right, key)
        }
    }

    /**
     * 搜索整个二分搜索树中 键为key 的节点
     */
    fun search(key: K): V? {
        return search(root, key)
    }

    /**
     * 搜索以 node 为根节点的树中键为 key 的节点
     */
    private fun search(node: Node?, key: K): V? {
        if (node == null) {
            return null
        }
        return when {
            node.key == key -> node.value
            key < node.key -> search(node.left, key)
            else -> search(node.right, key)
        }
    }

    /**
     * 前序遍历
     */
    fun preOrder() {
        preOrder(root)
    }

    /**
     * 对以二叉树 node 为根节点的树进行前序遍历
     */
    private fun preOrder(node: Node?) {
        if (node != null) {
            println("key:" + node.key + "  value:" + node.value)
            preOrder(node.left)
            preOrder(node.right)
        }
    }


    /**
     * 中序遍历
     */
    fun inOrder() {
        inOrder(root)
    }

    /**
     * 对以二叉树 node 为根节点的树进行中序遍历
     */
    private fun inOrder(node: Node?) {
        if (node != null) {
            inOrder(node.left)
            println("key:" + node.key + "  value:" + node.value)
            inOrder(node.right)
        }
    }


    fun postOrder() {
        postOrder(root)
    }

    /**
     * 对以二叉树 node 为根节点的树进行后序遍历
     */
    private fun postOrder(node: Node?) {
        if (node != null) {
            postOrder(node.left)
            postOrder(node.right)
            println("key:" + node.key + "  value:" + node.value)
        }
    }

    /**
     * 广度优先遍历，层级遍历
     */
    fun levelOrder() {
        val queue: Queue<Node> = ArrayDeque()
        queue.offer(root)
        while (!queue.isEmpty()) {
            val node = queue.poll()
            println("key:" + node.key + "  value:" + node.value)
            if (node.left != null) {
                queue.offer(node.left)
            }
            if (node.right != null) {
                queue.offer(node.right)
            }

        }
    }

    /**
     * 在二分搜索树中寻找最小值
     */
    fun minNum(): V? {
        if (root == null) {
            return null
        }
        return minNum(root!!).value
    }

    private fun minNum(root: Node): Node {
        if (root.left == null) {
            return root
        }
        return minNum(root.left!!)
    }


    /**
     * 在二分搜索树中寻找最大值
     */
    fun maxNum(): V? {
        if (root == null) {
            return null
        }
        return maxNum(root!!).value
    }

    private fun maxNum(root: Node): Node {
        if (root.right == null) {
            return root
        }
        return maxNum(root.right!!)
    }

    /**
     * 删除二叉树的最小节点
     */
    fun removeMin() {
        if (root == null) {
            return
        }
        root = removeMin(root!!)
    }

    private fun removeMin(node: Node): Node? {
        if (node.left == null) {
            count--
            return node.right
        }
        node.left = removeMin(node.left!!)
        return node
    }

    /**
     * 删除二叉树的最大节点
     */
    fun removeMax() {
        if (root == null) {
            return
        }
        root = removeMax(root!!)
    }

    private fun removeMax(node: Node): Node? {
        if (node.right == null) {
            count--
            return node.left
        }
        node.right = removeMax(node.right!!)
        return node
    }

    /**
     * 删除 key 所在的节点
     */
    fun remove(key: K) {
        root = remove(root, key)
    }

    private fun remove(node: Node?, key: K): Node? {
        if (node == null) {
            return null
        }
        if (key < node.key) {
            node.left = remove(node.left, key)
            return node
        } else if (key > node.key) {
            node.right = remove(node.right, key)
            return node
        } else {
            if (node.left == null) {
                count--
                return node.right
            }
            if (node.right == null) {
                count--
                return node.left
            }
            //找右节点的最小节点
            val successor = minNum(node.right!!)
            node.change(successor)
            successor.right=removeMin(node.right!!)
            successor.left=node.left
            return successor
        }

    }


    /**
     * 二分搜索树节点
     */
    internal inner class Node(var key: K, var value: V) {
        fun change(node: Node) {
            key=node.key
            value=node.value

        }

        var left: Node? = null
        var right: Node? = null

    }
}