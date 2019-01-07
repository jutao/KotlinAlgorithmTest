package algorithm.tree.bst

import sort.algorithm.tree.bst.BST

fun main(args: Array<String>) {
    val bst=BST()
    bst.insertRecursion(1)
    bst.insertRecursion(2)
    bst.insertRecursion(14)
    bst.insertRecursion(1)
    bst.insertRecursion(5)
    bst.insertRecursion(15)
    println(bst)
}