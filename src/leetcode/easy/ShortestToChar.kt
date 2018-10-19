package easy

/**
 * ****************************************
 * author：琚涛
 * time：2018/10/18
 * description：
给定一个字符串 S 和一个字符 C。返回一个代表字符串 S 中每个字符到字符串 S 中的字符 C 的最短距离的数组。

示例 1:

输入: S = "loveleetcode", C = 'e'
输出: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
说明:

字符串 S 的长度范围为 [1, 10000]。
C 是一个单字符，且保证是字符串 S 里的字符。
S 和 C 中的所有字母均为小写字母。
 * ****************************************
 */

fun shortestToChar(S: String, C: Char): IntArray {
    var temp: Int
    val shortArray = IntArray(S.length)
    val cArray = IntArray(S.length)
    var length = 0
    val chars = S.toCharArray()

    //记录下所有 C 的位置
    chars.indices
            .filter { chars[it] == C }
            .forEach { cArray[length++] = it }
    for (i in chars.indices) {
        if (chars[i] == C) {
            shortArray[i] = 0
            continue
        }
        var min = Math.abs(cArray[0] - i)
        for (j in 1 until length) {
            temp = Math.abs(cArray[j] - i)
            if (temp < min) {
                min = temp
            } else {
                break
            }
        }
        shortArray[i] = min
    }
    return shortArray
}