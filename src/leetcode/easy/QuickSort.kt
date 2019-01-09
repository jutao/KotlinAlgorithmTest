package easy

import sort.QuickSort
import java.util.*

/**
 * ****************************************
 * author：琚涛
 * time：2018/11/7
 * description：
 * ****************************************
 */
fun main(args: Array<String>) {
    val length = 10000000
    val arr = IntArray(length)
    val random = Random()
    for (i in 0 until length) {
        arr[i] = random.nextInt(length+5000)
    }
    val startTime2 = System.currentTimeMillis()
    QuickSort().quickSort(arr)
    val endTime2 = System.currentTimeMillis()
    println("耗时:" + (endTime2 - startTime2) + " ms")

}
 fun <T : Comparable<T>> sort(arr: Array<T>, n: Int) {
    quickSort(arr, 0, n - 1)
}

/**
 * 对 [l,r]进行快速排序
 */
private fun <T : Comparable<T>> quickSort(arr: Array<T>, l: Int, r: Int) {
    if (l >= r) {
        return
    }
    var p: Int = partition(arr, l, r)
    quickSort(arr, l, p - 1)
    quickSort(arr, p + 1, r)
}

private fun <T : Comparable<T>> partition(arr: Array<T>, l: Int, r: Int): Int {
    var v: T = arr[l]
    //arr[l+1,j]<v;arr[j+1,i]>v
    var j = l
    var temp:T
    for (i in l + 1..r) {
        if (arr[i] < v) {
            temp=arr[++j]
            arr[j]=arr[i]
            arr[i]=temp
        }
    }
    temp=arr[j]
    arr[j]=arr[l]
    arr[l]=temp
    return j
}
