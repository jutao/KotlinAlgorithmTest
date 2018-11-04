package sort

import algorithm.sort.BubbleSort
import algorithm.sort.InsertionSort
import algorithm.sort.MergeSort

fun main(args: Array<String>) {
    val arr = SortTestHelper.generateRandomArray(500, 5, 100000)
    println("------------------------------------")
    SortTestHelper.printArray(arr)
    //选择法排序
    selectionSort(arr)
}

fun selectionSort(arr: Array<Int>) {
    SortTestHelper.testSort("选择法排序",SelectionSort(),arr,arr.size)
    SortTestHelper.testSort("插入法排序", InsertionSort(),arr,arr.size)
    SortTestHelper.testSort("冒泡法排序", BubbleSort(),arr,arr.size)
    SortTestHelper.testSort("归并法排序", MergeSort(),arr,arr.size)
}


