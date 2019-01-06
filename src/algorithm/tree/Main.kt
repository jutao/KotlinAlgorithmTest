package algorithm.tree.bst

import sort.algorithm.tree.bst.BST

fun main(args: Array<String>) {
    val bst=BST()
    bst.insert(1)
    bst.insert(2)
    bst.insert(14)
    bst.insert(1)
    bst.insert(5)
    bst.insert(15)
    println(bst)
}