package sort.algorithm.tree

class BinarySearch {
    /**
     * 二分查找法，在有序数组arr中查找target
     * 返回相应的索引 index
     */
    fun binarySearch(arr: IntArray, n: Int, target: Int): Int {
        //在[l..r]之中查找target
        var l = 0
        var r = n - 1
        while (l <= r) {
            //这样会出现超出 Int范围从而溢出的问题
//            var mid = (l + r) / 2
            var mid = l + (r - l) / 2
            if (arr[mid] == target) {
                return mid
            }
            if (arr[mid] > target) {
                r = mid - 1
            } else {
                l = mid + 1
            }
        }
        return -1
    }
}