package sort

fun main(args: Array<String>) {
    val arr = SortTestHelper.generateRandomArray(20, 5, 100)
    println("------------------------------------")
    SortTestHelper.printArray(arr)
    //选择法排序
    selectionSort(arr)
}

fun selectionSort(arr: Array<Int>) {
    SortTestHelper.testSort("选择法排序",SelectionSort(),arr,arr.size)
}


