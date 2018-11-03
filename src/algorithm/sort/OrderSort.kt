package algorithm.sort

import sort.Sort
import sort.SortTestHelper

/**
 * 顺序法排序
 */
class OrderSort : Sort {
    override fun <T : Comparable<T>> sort(arr: Array<T>, n: Int) {
        for (i in 0 until n-1){
            for (j in i+1 until n){
                if(arr[i]>arr[j]){
                    SortTestHelper.swap(arr,i,j)
                }
            }
        }
    }

}