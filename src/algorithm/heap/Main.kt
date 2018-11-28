package algorithm.heap

import algorithm.sort.QuickSort
import algorithm.sort.QuickSort3Ways
import sort.SortTestHelper
import sort.TestHelper
import sort.algorithm.heap.HeapSort
import sort.algorithm.heap.HeapSort1
import sort.algorithm.heap.HeapSort2

fun main(args: Array<String>) {
//   val maxHeap = MaxHeap(100000)
    val arr = SortTestHelper.generateRandomIntArray(10000000, 5, 10000)
    val arr2 = arr.clone()
    val arr3 = arr.clone()
//    for (i in arr) {
//        maxHeap.insert(i)
//    }
//    println("数组原本：")
//    for (a in arr) {
//        print("$a ")
//    }
//    println()
//    println("堆打印出来：")
//    maxHeap.print()
//    println()
//    println()
//    while (!maxHeap.isEmpty()){
//        println("extractMax:"+maxHeap.extractMax())
//    }
    TestHelper.testSort("堆排序1",HeapSort1(),arr,arr.size)
    TestHelper.testSort("堆排序2", HeapSort2(),arr2,arr2.size)
    TestHelper.testSort("堆排序", HeapSort(),arr3,arr3.size)
}