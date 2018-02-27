package sort

import java.util.*

class SortTestHelper {
    /**
     * 生成 n 个元素的随机数组，每个元素的范围是 [rangeL,rangeR]
     */
    companion object {
        @JvmStatic
        fun generateRandomArray(n:Int,rangeL:Int,rangeR:Int):IntArray{
            assert(rangeL<rangeR)
            var arr:IntArray= IntArray(n)
            for(i in 0 until n){
                arr[i]=Random().nextInt(rangeR-rangeL+1)+rangeL
            }
            return arr
        }

        /**
         * 输出数组各个元素
         */
        @JvmStatic
        fun printArray(arr:IntArray){
            for (a in arr) {
                print(a)
                print(" ")
            }
        }
    }

}