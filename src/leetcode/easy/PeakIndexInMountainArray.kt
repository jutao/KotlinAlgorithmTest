package easy

/**
 * ****************************************
 * author：琚涛
 * time：2018/10/8
 * description：我们把符合下列属性的数组 A 称作山脉：

A.length >= 3
存在 0 < i < A.length - 1 使得A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
给定一个确定为山脉的数组，返回任何满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 的 i 的值。



示例 1：

输入：[0,1,0]
输出：1
示例 2：

输入：[0,2,1,0]
输出：1


提示：

3 <= A.length <= 10000
0 <= A[i] <= 10^6
A 是如上定义的山脉
 * ****************************************
 */
fun main(args: Array<String>) {
    println(PeakIndexInMountainArray.peakIndexInMountainArray(intArrayOf(1, 5, 8,55,8,66,22)))
}

class PeakIndexInMountainArray {

    companion object {
        @JvmStatic
        fun peakIndexInMountainArray(A: IntArray): Int {
            var i=0
            var j=A.size-1
            var mid:Int
            while (i<j){
                mid=(i+j)/2
                if(A[mid]>A[mid+1]){
                   j=mid
                }else{
                    i=mid+1
                }
            }
            return j
        }
    }
}