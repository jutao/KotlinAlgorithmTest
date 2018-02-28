package sort

/**
 * 选择排序法
 */
class SelectionSort :Sort{
    override fun <T : Comparable<T>> sort(arr: Array<T>, n: Int) {
        for (i in 0 until n) {
            //寻找[i,n)的最小值
            var minIndex: Int = i
            ((i + 1) until n)
                    .asSequence()
                    .filter { arr[minIndex] > arr[it] }
                    .forEach { minIndex = it }
            if (minIndex != i) {
                SortTestHelper.swap(arr, minIndex, i)
            }
        }
    }
}