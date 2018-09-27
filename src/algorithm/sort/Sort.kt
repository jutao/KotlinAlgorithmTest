package sort

interface Sort {
    /**
     * 排序
     */
    fun<T:Comparable<T>> sort(arr:Array<T>,n:Int)
}