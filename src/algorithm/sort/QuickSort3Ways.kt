package algorithm.sort

import sort.Sort
import sort.SortTestHelper
import java.util.*

/**
 * 3路快排
 * 将 arr 分为 <v;==v;>v 三部分
 * 之后递归继续对 <v;>v两部分进行 3路快排序
 *
 * 32:00
 */
class QuickSort3Ways : Sort {
    override fun <T : Comparable<T>> sort(arr: Array<T>, n: Int) {
        quickSort3Ways(arr, 0, n - 1)
    }

    /**
     * 对 [l,r]进行快速排序
     */
    private fun <T : Comparable<T>> quickSort3Ways(arr: Array<T>, l: Int, r: Int) {
        if(l>=r){
            return
        }
        SortTestHelper.swap(arr, l, Random().nextInt(r - l + 1) + l)
        var v: T = arr[l]
        //arr[l+1..lt]<v
        var lt = l
        //arr[gt..r]>v
        var gt = r + 1
        //arr[lt+1..i]==v
        var i=l+1
        while (i<gt){
            if(arr[i]<v){
                SortTestHelper.swap(arr,i,lt+1)
                lt++
                i++
            }else if(arr[i]>v){
                SortTestHelper.swap(arr,i,gt-1)
                gt--
            }else{
                i++
            }
        }
        SortTestHelper.swap(arr,l,lt)

        quickSort3Ways(arr, l, lt-1)
        quickSort3Ways(arr, gt, r)

    }

}