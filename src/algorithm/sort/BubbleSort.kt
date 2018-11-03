package algorithm.sort

import sort.Sort
import sort.SortTestHelper

/**
 * 冒泡法排序
 */
class BubbleSort : Sort {
    override fun <T : Comparable<T>> sort(arr: Array<T>, n: Int) {
        for (i in 0 until n-1){
            for (j in 0 until n-i-1){
                if(arr[j]>arr[j+1]){
                    SortTestHelper.swap(arr,j+1,j)
                }
            }
        }
    }

}