package sort.algorithm.heap

import sort.IntSort
import sort.TestHelper

/**
 * 堆排序
 */
class HeapSort : IntSort {
    override fun sort(arr: IntArray, n: Int) {
        //首先把数组转化成堆
        for(i in (n-1)/2 downTo 0){
            shiftDown(i,n,arr)
        }
        for (i in n-1 downTo 1){
            //在最大堆中，arr[0]一定是最大的数,将它和 arr[i]交换，即可保证最大的数在正确的位置
            TestHelper.swap(arr,i,0)
            //此时arr[0]使[0,i-1]不满足最大堆，因此执行 shiftDown操作
            shiftDown(0,i,arr)
        }
    }

    private fun shiftDown(k: Int, n: Int, arr: IntArray) {
        var p = k
        while (2*p+1 < n) {
            var j = 2*p+1
            if (j + 1 < n && arr[j + 1] > arr[j]) {
                j += 1
            }
            if (arr[p] >= arr[j]) {
                break
            }
            TestHelper.swap(arr, p, j)
            p = j
        }
    }

}