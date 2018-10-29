package hard

/**
 * ****************************************
 * author：琚涛
 * time：2018/10/19
 * description：
如果正整数可以被 A 或 B 整除，那么它是神奇的。

返回第 N 个神奇数字。由于答案可能非常大，返回它模 10^9 + 7 的结果。

示例 1：
输入：N = 1, A = 2, B = 3
输出：2

示例 2：
输入：N = 4, A = 2, B = 3
输出：6

示例 3：
输入：N = 5, A = 2, B = 4
输出：10

示例 4：
输入：N = 3, A = 6, B = 4
输出：8
 * ****************************************
 */

fun main(args: Array<String>) {

}

fun nthMagicalNumber(N: Int, A: Int, B: Int): Int {
    var low: Long = 0
    var high: Long = 2000000000000000000L
    var g = A * B / gcd(A, B)
    while (low < high) {
        var mid: Long = (low + high) / 2
        var temp: Long = mid / A + mid / B - mid / g
        if (temp < N) {
            low = mid + 1
        } else
            high = mid;
    }
    return ((high % 1000000007).toInt())
}

fun gcd(a: Int, b: Int): Int {
    if (b == 0) {
        return a
    }
    return gcd(b, a % b)
}
