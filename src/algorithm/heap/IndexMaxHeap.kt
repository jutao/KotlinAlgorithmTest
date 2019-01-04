package sort

/**
 * ****************************************
 * author：琚涛
 * time：2019/1/3
 * description：最大索引堆
 * ****************************************
 */

class IndexMaxHeap(capacity: Int) {
    private var data: IntArray = IntArray(capacity + 1)
    private var indexes: IntArray = IntArray(capacity + 1)
    //reverse[i] 表示索引 i 在 indexes（堆）中的位置。引入 reveres 数组的意义是，可以在执行 change 这个方法的时候，使用 O(1) 这个时间复杂度，直接找到
    private var reverse: IntArray = IntArray(capacity + 1)
    private var count: Int = 0
    private var capacity: Int = capacity


    fun size(): Int {
        return count
    }

    fun isEmpty(): Boolean {
        return count == 0
    }

    fun insert(index: Int, item: Int) {
        if (count == capacity) {
            capacity *= 2
            val copy1 = IntArray(capacity)
            val copy2 = IntArray(capacity)
            for (i in 0 until data.size) {
                copy1[i] = data[i]
                copy2[i] = indexes[i]
            }
            data = copy1
            indexes = copy2

        }
        var i = index
        i += 1
        data[i] = item
        indexes[++count] = i
        reverse[i] = count + 1
        shiftUp(count)
    }

    private fun shiftUp(k: Int) {
        var index = k
        while (index > 1 && data[indexes[index / 2]] < data[indexes[index]]) {
            TestHelper.swap(indexes, index, index / 2)
            reverse[indexes[k / 2]] = k / 2
            reverse[indexes[k]] = k
            index /= 2
        }
    }

    /**
     * 打印堆
     */
    fun print() {
        for (i in 1..count) {
            print(data[indexes[i]])
            print(" ")
        }
        println()
        for (i in 1..count) {
            print(indexes[i])
            print(" ")
        }
        println()
        for (i in 1..count) {
            print(reverse[i])
            print(" ")
        }
    }

    fun change(index: Int, newItem: Int) {
        assert(contain(index))
        var i = index + 1
        data[i] = newItem

        shiftUp(reverse[i])
        shiftDown(reverse[i])
    }

    fun get(index: Int): Int {
        assert(contain(index))
        return data[indexes[index+1]]
    }

    private fun contain(index: Int): Boolean {
        return reverse[index + 1] != 0
    }

    /**
     * 1、获取最大元素的索引
     */
    fun extractMaxIndex(): Int {
        if (count <= 0) {
            return 0
        }
        val ret = indexes[1] - 1
        TestHelper.swap(indexes, 1, count)
        reverse[indexes[1]] = 1
        reverse[indexes[count]] = 0
        count--
        shiftDown(1)
        return ret
    }

    /**
     * 把小于子节点的父节点放到合适的位置去
     */
    private fun shiftDown(k: Int) {
        var p = k
        while (p * 2 <= count) {
            var j = p * 2
            if (j + 1 <= count && data[indexes[j + 1]] > data[indexes[j]]) {
                j += 1
            }
            if (data[indexes[p]] >= data[indexes[j]]) {
                break
            }
            TestHelper.swap(indexes, p, j)
            reverse[indexes[p]] = p
            reverse[indexes[j]] = j
            p = j
        }
    }

    /**
     * 将数组转化成堆
     */
    fun heapify(arr: IntArray) {
        for (i in 0 until arr.size) {
            data[i + 1] = arr[i]
            indexes[i + 1] = i + 1
            reverse[i + 1] = i + 1
        }
        count = arr.size
        for (i in count / 2 downTo 1) {
            shiftDown(i)
        }
    }
}
