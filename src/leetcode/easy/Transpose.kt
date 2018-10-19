package easy

/**
 * ****************************************
 * author：琚涛
 * time：2018/10/12
 * description：867. 转置矩阵
给定一个矩阵 A， 返回 A 的转置矩阵。

矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。



示例 1：
输入：[[1,2,3],[4,5,6],[7,8,9]]
输出：[[1,4,7],[2,5,8],[3,6,9]]

示例 2：
输入：[[1,2,3],[4,5,6]]
输出：[[1,4],[2,5],[3,6]]
 * ****************************************
 */
fun main(args: Array<String>) {
    val A: Array<IntArray> = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7,8,9), intArrayOf(8,9))
    val transpose = transpose(A)
    println(transpose)
}

fun transpose(A: Array<IntArray>): Array<IntArray> {
    val lineSize = A[0].size
    val rowSize = A.size
    val B: Array<IntArray> = Array(lineSize) { IntArray(rowSize) }
    for (i in 0..(lineSize - 1)) {
        for (j in 0..(rowSize - 1)) {
            B[i][j] = A[j][i]
        }
    }
    return B
}