package sort

import algorithm.sort.InsertionSort
import algorithm.sort.MergeSort
import algorithm.sort.QuickSort

fun main(args: Array<String>) {
    val arr = SortTestHelper.generateRandomArray(10, 5, 100)
    println("------------------------------------")
    SortTestHelper.printArray(arr)
    //选择法排序
    selectionSort(arr)
}

fun selectionSort(arr: Array<Int>) {
    val clone1 = arr.clone()
    val clone2 = arr.clone()
//    SortTestHelper.testSort("选择法排序",SelectionSort(),arr,arr.size)
//    SortTestHelper.testSort("插入法排序", InsertionSort(),arr,arr.size)
//    SortTestHelper.testSort("冒泡法排序", BubbleSort(),arr,arr.size)
//    SortTestHelper.testSort("归并法排序", MergeSort(),clone1,clone1.size)
    SortTestHelper.testSort("快速排序法", QuickSort(),clone2,clone2.size)
}


