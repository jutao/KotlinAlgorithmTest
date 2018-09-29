package leetcode.easy

fun main(args: Array<String>) {
    val sortArrayByParity = SortArrayByParity.sortArrayByParity(intArrayOf(1, 2, 3, 4, 5, 6))
    for (i in sortArrayByParity) {
        println(i)
    }

}

/**
 * 给定一个非负整数数组 A，返回一个由 A 的所有偶数元素组成的数组，后面跟 A 的所有奇数元素。

    你可以返回满足此条件的任何数组作为答案。

    输入：[3,1,2,4]
    输出：[2,4,3,1]
    输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 */
class SortArrayByParity{
    companion object {
        @JvmStatic
        fun sortArrayByParity(A: IntArray): IntArray {

            val n=A.size
            val B=IntArray(n)
            var a=0
            var b=A.size-1
            for (i in A) {
                if(i%2==0){
                    B[a++]=i
                }else{
                    B[b--]=i
                }
            }
            return B
        }
    }
}