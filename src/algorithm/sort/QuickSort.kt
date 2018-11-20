package algorithm.sort

import sort.Sort
import sort.SortTestHelper
import java.util.*

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
        var p: Int = partition2(arr, l, r)
        quickSort(arr, l, p - 1)
        quickSort(arr, p + 1, r)
    }

    
    private fun <T : Comparable<T>> partition(arr: Array<T>, l: Int, r: Int): Int {
        SortTestHelper.swap(arr, l, Random().nextInt(r - l + 1) + l)
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

    /**
     * 优化快排 2路快拍方法
     * 避免 arr[index]=v 的情况造成分组不均衡
     */
    private fun <T : Comparable<T>> partition2(arr: Array<T>, l: Int, r: Int): Int {
        //随机选择 partition ，以免基本有序的数组效率过低
        SortTestHelper.swap(arr, l, Random().nextInt(r - l + 1) + l)
        var v: T = arr[l]

        var i = l + 1
        var j = r
        while (true) {
            while (i <= r && arr[i] < v) {
                i++
            }
            while (j >= l + 1 && arr[j] > v) {
                j--
            }
            if (i > j) {
                break
            }
            SortTestHelper.swap(arr, i, j)
            i++
            j--
        }
        SortTestHelper.swap(arr, l, j)
        return j
    }

}