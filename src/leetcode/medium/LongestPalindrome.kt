package medium


/**
 * ****************************************
 * author：琚涛
 * time：2018/11/1
 * description：5. 最长回文子串
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba"也是一个有效答案。

示例 2：
输入: "cbbd"
输出: "bb"
 * ****************************************
 */
fun main(args: Array<String>) {
    println(longestPalindrome("dababad"))
}

fun longestPalindrome(s: String): String {
    val T = preProcess(s)
    val n: Int = T.length
    val P = IntArray(n)
    var C = 0
    var R = 0
    for (i in 1 until n - 1) {
        // equals to i' = C - (i-C)
        var i_mirror:Int = 2*C-i

        if(R>i){
            P[i] =Math.min(R-i, P[i_mirror])
        }else{
            P[i]=0
        }

        // Attempt to expand palindrome centered at i
        while (T[i + 1 + P[i]] == T[i - 1 - P[i]]){
            P[i]++
        }


        // If palindrome centered at i expand past R,
        // adjust center based on expanded palindrome.
        if (i + P[i] > R) {
            C = i
            R = i + P[i]
        }
    }

    // Find the maximum element in P.
    var maxLen = 0
    var centerIndex = 0
    for (i in 1 until n - 1) {
        if (P[i] > maxLen) {
            maxLen = P[i]
            centerIndex = i
        }
    }
    return s.substring((centerIndex - 1 - maxLen) / 2,(centerIndex - 1 - maxLen) / 2+ maxLen)
}

fun preProcess(s: String): String {
    val n = s.length
    if (n == 0) return "^$"
    var ret = "^"
    for (i in 0 until n){
        ret += "#" + s.substring(i, i+1)
    }
    ret += "#$"
    return ret
}
