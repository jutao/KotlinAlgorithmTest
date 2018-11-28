package sort.algorithm.heap

import algorithm.heap.MaxHeap
import sort.IntSort

/**
 * 堆排序2
 */
class HeapSort2  :IntSort{
     override fun  sort(arr: IntArray, n: Int) {
        val maxHeap= MaxHeap(n)
         maxHeap.heapify(arr)
        for(i in n-1 downTo 0){
            arr[i]= maxHeap.extractMax()
        }

    }

}