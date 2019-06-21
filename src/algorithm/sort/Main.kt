package sort

import algorithm.sort.*

fun main(args: Array<String>) {
    val arr = SortTestHelper.generateRandomArray(10000, 5, 99999)
    println("------------------------------------")
    SortTestHelper.printArray(arr)
    //选择法排序
    selectionSort(arr)
}

fun selectionSort(arr: Array<Int>) {
    val clone1 = arr.clone()
    val clone2 = arr.clone()
    val clone3 = arr.clone()
    val clone4 = arr.clone()
    val clone5 = arr.clone()
    val clone6 = arr.clone()
    SortTestHelper.testSort("选择法排序",SelectionSort(),clone1,arr.size)
    SortTestHelper.testSort("插入法排序", InsertionSort(),clone2,arr.size)
    SortTestHelper.testSort("冒泡法排序", BubbleSort(),clone3,arr.size)
    SortTestHelper.testSort("归并法排序", MergeSort(),clone4,arr.size)
    SortTestHelper.testSort("快速排序法", QuickSort(),clone5,arr.size)
    SortTestHelper.testSort("三路快速排序法", QuickSort3Ways(),clone6,arr.size)


}

