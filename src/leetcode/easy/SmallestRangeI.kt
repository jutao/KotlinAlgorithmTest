package leetcode.easy

import java.util.*

/**
 * 给定一个整数数组 A，对于每个整数 A[i]，我们可以选择任意 x 满足 -K <= x <= K，并将 x 加到 A[i] 中。

    在此过程之后，我们得到一些数组 B。

    返回 B 的最大值和 B 的最小值之间可能存在的最小差值。

    示例 1：
    输入：A = [1], K = 0
    输出：0
    解释：B = [1]

    示例 2：
    输入：A = [0,10], K = 2
    输出：6
    解释：B = [2,8]

    示例 3：
    输入：A = [1,3,6], K = 3
    输出：0
    解释：B = [3,3,3] 或 B = [4,4,4]
 */
fun main(args: Array<String>) {
    println(SmallestRangeI.smallestRangeI(intArrayOf(0,10), 2))
}
class SmallestRangeI{
    companion object {
        /**
         * 最小差值 I 完成，理解题目花了一点时间，想通很简单，就是最大值尽量变小，最小值尽量变大。
         * 但是如果最大值变小后小于最小值变大，说明差值可以为零
         */
        @JvmStatic
        fun smallestRangeI(A: IntArray, K: Int): Int {
            Arrays.sort(A)
            A[0]+=K
            A[A.size-1]-=K
            val result=A[A.size-1]-A[0]
            return if(result<0){
                0
            }else{
                result
            }
        }
    }
}