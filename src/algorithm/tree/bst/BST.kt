package sort.algorithm.tree.bst


/**
 * 二分搜索树
 */
internal class BST {
    private var root: Node? = null
    private var count = 0

    val isEmpty: Boolean
        get() = count == 0

    fun size(): Int {
        return count
    }

    /**
     * 插入一个值到搜索树
     */
    fun insert(value: Int) {
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
     * 二分搜索树节点
     */
    internal inner class Node(var value: Int) {
        var left: Node? = null
        var right: Node? = null

    }
}