package algorithm.heap

import sort.SortTestHelper

fun main(args: Array<String>) {
    val maxHeap = MaxHeap(100)
    val arr = SortTestHelper.generateRandomArray(15, 0, 100)
    for (i in arr) {
        maxHeap.insert(i)
    }

    println("数组原本：")
    for (a in arr) {
        print("$a ")
    }
    println()
    println("堆打印出来：")
    maxHeap.print()
}