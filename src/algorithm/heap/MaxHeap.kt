package algorithm.heap

import sort.SortTestHelper
import sort.TestHelper

/**
 * 最大堆
 */
class MaxHeap(capacity: Int) {
    private var data: IntArray = IntArray(capacity + 1)
    private var count: Int = 0
    private var capacity: Int = capacity


    fun size(): Int {
        return count
    }

    fun isEmpty(): Boolean {
        return count == 0
    }

    fun insert(item: Int) {
        if (count == capacity) {
            capacity *= 2
            val copy = IntArray(capacity)
            for (i in 0 until data.size) {
                copy[i] = data[i]
            }
            data = copy

        }
        data[++count] = item
        shiftUp(count)
    }

    private fun shiftUp(k: Int) {
        var index = k
        while (index > 1 && data[index / 2] < data[index]) {
            SortTestHelper.swap(data, index, index / 2)
            index /= 2
        }
    }

    /**
     * 打印堆
     */
    fun print() {
        for (i in 1..count) {
            print(data[i])
            print(" ")
        }
    }


    /**
     * 1、获取 data[1]，即整个堆最大的元素
     * 2、把最后一个元素放到第一个来，总数减一
     * 3、把刚才放过来的最后一个元素放到合适的位置
     */
    fun extractMax(): Int {
        if (count <= 0) {
            return 0
        }
        val ret = data[1]
        TestHelper.swap(data, 1, count)
        count--
        shiftDown(1)
        return ret
    }

    /**
     * 把小于子节点的父节点放到合适的位置去
     */
    private fun shiftDown(k: Int) {
        var p = k
        while (p*2 <= count) {
            var j = p*2
            if (j + 1 <= count && data[j + 1] > data[j]) {
                j += 1
            }
            if (data[p] >= data[j]) {
                break
            }
            TestHelper.swap(data, p, j)
            p = j
        }
    }

    /**
     * 将数组转化成堆
     */
    fun heapify(arr: IntArray) {
        for (i in 0 until arr.size){
            data[i+1]=arr[i]
        }
        count=arr.size
        for(i in count/2 downTo 1){
            shiftDown(i)
        }
    }
}