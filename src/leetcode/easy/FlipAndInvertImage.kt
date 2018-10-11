package leetcode.easy

fun main(args: Array<String>) {
    val A: Array<IntArray> = arrayOf(intArrayOf(1,1,0),intArrayOf(1,1,1),intArrayOf(0,0,0))
    val flipAndInvertImage = FlipAndInvertImage.flipAndInvertImage(A)
    println(flipAndInvertImage)
}


class FlipAndInvertImage {
    companion object {
        @JvmStatic
        fun flipAndInvertImage(A: Array<IntArray>): Array<IntArray> {
            for (i in A.indices) {
                val length = A[i].size
                for (j in 0..(length / 2-1)) {
                    var temp = A[i][j]
                    A[i][j] = A[i][length - 1 - j]
                    A[i][length - 1 - j] = temp
                }
                for (j in A[i].indices) {
                    if (A[i][j] == 0) {
                        A[i][j] = 1
                    } else {
                        A[i][j] = 0
                    }
                }
            }
            return A
        }
    }
}