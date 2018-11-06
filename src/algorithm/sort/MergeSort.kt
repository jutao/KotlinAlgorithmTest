package algorithm.sort

import sort.Sort

/**
 * 归并排序
 */
class MergeSort : Sort {
    override fun <T : Comparable<T>> sort(arr: Array<T>, n: Int) {
        mergeSort(arr, 0, n - 1)
    }

    /**
     * 递归使用归并排序，对 arr[l,r]的范围进行排序
     */
    private fun <T : Comparable<T>> mergeSort(arr: Array<T>, l: Int, r: Int) {
        if (l >= r) {
            return
        }
        //这里有个风险，l+r的值可能会超出 int 的范围
        var mid = (l + r) / 2
        mergeSort(arr, l, mid)
        mergeSort(arr, mid + 1, r)
        if(arr[mid]>arr[mid+1]){
            merge(arr, l, mid, r)
        }

    }

    /**
     * 将 arr[l,mid] 与 arr[mid+1,r] 两部分进行归并
     */
    private fun <T : Comparable<T>> merge(arr: Array<T>, l: Int, mid: Int, r: Int) {
        val aux = arrayOfNulls<Any>(r - l + 1)
        for (i in l..r) {
            aux[i - l] = arr[i]
        }
        //左边的数组归并的序号
        var i = l
        //右边的数组归并的序号
        var j = mid + 1
        for (k in l..r) {
            when {
                i > mid -> {
                    arr[k] = aux[j - l] as T
                    j++
                }
                j > r -> {
                    arr[k] = aux[i - l] as T
                    i++
                }
                aux[i - l] < aux[j - l] -> {
                    arr[k] = aux[i - l] as T
                    i++
                }
                else -> {
                    arr[k] = aux[j - l] as T
                    j++
                }
            }
        }
    }

}

private operator fun Any?.compareTo(any: Any?): Int {
    return try {
        val a = this as Int
        val b = any as Int
        when {
            a > b -> 1
            a < b -> -1
            else -> 0
        }
    } catch (exception: Exception) {
        0
    }

}




