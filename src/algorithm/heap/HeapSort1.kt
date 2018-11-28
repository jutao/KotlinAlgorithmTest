package sort.algorithm.heap

import algorithm.heap.MaxHeap
import sort.IntSort

/**
 * 堆排序1
 */
class HeapSort1  :IntSort{
     override fun  sort(arr: IntArray, n: Int) {
        val maxHeap= MaxHeap(n)
         for(i in 0 until n){
             maxHeap.insert(arr[i])
         }
        for(i in n-1 downTo 0){
            arr[i]= maxHeap.extractMax()
        }

    }

}