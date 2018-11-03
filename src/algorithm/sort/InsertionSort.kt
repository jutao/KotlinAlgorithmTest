package algorithm.sort

import sort.Sort
import sort.SortTestHelper

/**
 * 插入法排序
 */
class InsertionSort : Sort {
    override fun <T : Comparable<T>> sort(arr: Array<T>, n: Int) {
        for (i in 1 until n) {
            var j = i
            var temp = arr[i]
            while (j > 0 && temp < arr[j - 1]) {
                arr[j] = arr[j - 1]
                j--
            }
            arr[j] = temp
        }
    }

}