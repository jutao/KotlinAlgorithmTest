package sort.algorithm.tree.bst


/**
 * 二分搜索树
 */
fun main(args: Array<String>) {
    val bst: BST<String, Int> = BST()
    bst.insertNormal("a", 1)
    bst.insertNormal("b", 2)
    bst.insertNormal("c", 3)
    bst.insertNormal("aa", 4)
    bst.insertRecursion("cc", 5)
    bst.insertNormal("dd", 6)
    bst.insertNormal("dd", 7)
    bst.insertNormal("bc", 8)
    println(bst.search("bc"))
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
     * 二分搜索树节点
     */
    internal inner class Node(var key: K, var value: V) {
        var left: Node? = null
        var right: Node? = null

    }
}