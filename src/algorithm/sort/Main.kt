package sort

import algorithm.sort.BubbleSort
import algorithm.sort.InsertionSort

fun main(args: Array<String>) {
    val arr = SortTestHelper.generateRandomArray(1000, 5, 1000)
    println("------------------------------------")
    SortTestHelper.printArray(arr)
    //选择法排序
    selectionSort(arr)
}

fun selectionSort(arr: Array<Int>) {
    SortTestHelper.testSort("选择法排序",SelectionSort(),arr,arr.size)
    SortTestHelper.testSort("插入法排序", InsertionSort(),arr,arr.size)
    SortTestHelper.testSort("冒泡法排序", BubbleSort(),arr,arr.size)
}


