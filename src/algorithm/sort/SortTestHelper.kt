package sort

import java.util.*

class SortTestHelper {

    companion object {
        /**
         * 生成 n 个元素的随机数组，每个元素的范围是 [rangeL,rangeR]
         */
        @JvmStatic
        fun generateRandomArray(n:Int,rangeL:Int,rangeR:Int):Array<Int>{
            assert(rangeL<rangeR)
            var arr:Array<Int> =Array(n) { i -> i * i }
            for(i in 0 until n){
                arr[i]=Random().nextInt(rangeR-rangeL+1)+rangeL
            }
            return arr
        }
        /**
         * 生成 n 个元素的随机数组，每个元素的范围是 [rangeL,rangeR]
         */
        @JvmStatic
        fun generateRandomIntArray(n:Int,rangeL:Int,rangeR:Int):IntArray{
            assert(rangeL<rangeR)
            var arr =IntArray(n)
            for(i in 0 until n){
                arr[i]=Random().nextInt(rangeR-rangeL+1)+rangeL
            }
            return arr
        }

        /**
         * 输出数组各个元素
         */
        @JvmStatic
        fun <T : Comparable<T>> printArray(arr:Array<T>){
            for (a in arr) {
                print("$a ")
            }
            println()
        }
        /**
         * 输出数组各个元素
         */
        @JvmStatic
        fun  printArray(arr:IntArray){
            for (a in arr) {
                print("$a ")
            }
            println()
        }

        /**
         * 交换arr数组的第i个和第j个元素
         */
        @JvmStatic
        fun<T : Comparable<T>> swap(arr: Array<T>, i: Int, j: Int) {
            val temp = arr[i]
            arr[i]=arr[j]
            arr[j]=temp
        }
        /**
         * 交换arr数组的第i个和第j个元素
         */
        @JvmStatic
        fun swap(arr: IntArray, i: Int, j: Int) {
            val temp = arr[i]
            arr[i]=arr[j]
            arr[j]=temp
        }

        /**
         * 执行排序，并输出排序花费的时间
         */
        @JvmStatic
        fun<T : Comparable<T>> testSort(methodName: String, sort: Sort, arr: Array<T>, size: Int) {
            val startTime:Long = System.currentTimeMillis()
            sort.sort(arr,size)
            val endTime:Long = System.currentTimeMillis()
            println(methodName+"共花费了"+(endTime-startTime)+"ms 对"+size+"个数进行排序,"+"排序结果如下:")
            SortTestHelper.printArray(arr)
            println("排序"+isSorted(arr,size))
            println("------------------------------------")
        }

        /**
         * 检查是否排序成功
         */
        @JvmStatic
        private fun <T : Comparable<T>> isSorted(arr: Array<T>, size: Int):String {
            return if ((0 until (size-1)).any { arr[it]>arr[it +1] }) "失败" else "成功"
        }
    }

}