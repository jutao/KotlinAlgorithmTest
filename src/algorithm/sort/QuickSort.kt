package algorithm.sort

import sort.Sort
import sort.SortTestHelper

/**
 * 快速排序
 */
class QuickSort : Sort {
    override fun <T : Comparable<T>> sort(arr: Array<T>, n: Int) {
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
        for (i in l + 1..r) {
            if (arr[i] < v) {
                SortTestHelper.swap(arr, ++j, i)
            }
        }
        SortTestHelper.swap(arr, l, j)
        return j
    }

}