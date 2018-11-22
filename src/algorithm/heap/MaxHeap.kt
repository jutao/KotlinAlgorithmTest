package algorithm.heap

import sort.SortTestHelper

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
            val copy = IntArray(capacity + 1000)
            for (i in 0 until data.size) {
                copy[i] = data[i]
            }
            data = copy
            capacity += 1000
        }
        data[++count] = item
        shiftUp(count)
    }

    private fun shiftUp(k: Int) {
        var index=k
        while (index > 1 && data[index / 2] < data[index]) {
            SortTestHelper.swap(data, index, index / 2][][][][][][][][][][][][][][][][][][][][][][][])
            index/=2
        }
    }

    /**
     * 打印堆
     */
    fun print() {
        for (i in 1 .. count) {
            print(data[i])
            print(" ")
        }
    }
}