package medium

import java.util.*
import kotlin.collections.HashMap

/**
 * ****************************************
 * author：琚涛
 * time：2018/10/31
 * description：870. 优势洗牌
 *
给定两个大小相等的数组 A 和 B，A 相对于 B 的优势可以用满足 A[i] > B[i] 的索引 i 的数目来描述。

返回 A 的任意排列，使其相对于 B 的优势最大化。



示例 1：

输入：A = [2,7,11,15], B = [1,10,4,11]
输出：[2,11,7,15]
示例 2：

输入：A = [12,24,8,32], B = [13,25,32,11]
输出：[24,32,8,12]
 * ****************************************
 */
fun main(args: Array<String>) {
    val a = intArrayOf(2, 0, 4, 1, 2)
    val b = intArrayOf(1, 3, 0, 0, 2)
    val ints = advantageCount(a, b)
    for (anInt in ints) {
        println(anInt)
    }
}

fun advantageCount(A: IntArray, B: IntArray): IntArray {
    val sortA = A.clone()
    val sortB = B.clone()
    sortA.sort()
    sortB.sort()

    val helpMap: HashMap<Int, LinkedList<Int>> = HashMap()
    val remainA: LinkedList<Int> = LinkedList()

    for (i in B) {
        helpMap.put(i, LinkedList())
    }

    var j = 0
    for (a in sortA) {
        if (a > sortB[j]) {
            (helpMap[sortB[j++]])?.add(a)
        } else {
            remainA.add(a)
        }
    }
    val result =  IntArray(B.size)
    for (i in 0 until B.size){
        if(helpMap.get(B[i])!!.size>0){
            result[i]= helpMap.get(B[i])!!.pop()
        }else{
            result[i]=remainA.pop()
        }
    }

    return result
}