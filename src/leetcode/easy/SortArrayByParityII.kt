package easy

/**
 * ****************************************
 * author：琚涛
 * time：2018/10/16
 * description：
给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。

对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。

你可以返回任何满足上述条件的数组作为答案。
 * ****************************************
 */
fun main(args: Array<String>) {
    val sortArrayByParityII = sortArrayByParityII(intArrayOf(2, 4, 6, 1, 3, 5))
    for (i in sortArrayByParityII) {
        println(i)
    }

}

fun sortArrayByParityII(A: IntArray): IntArray {
    val C=IntArray(A.size)
    var a=0
    var b=1
    for(i in 0 until A.size){
       if(A[i]%2==0){
           C[a]=A[i]
           a+=2
       }else{
           C[b]=A[i]
           b+=2
       }
    }
    return C
}