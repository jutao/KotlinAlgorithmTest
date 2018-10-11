package easy

/**
 * ****************************************
 * author：琚涛
 * time：2018/10/11
 * description：编写一个函数，其作用是将输入的字符串反转过来。

    示例 1:

    输入: "hello"
    输出: "olleh"
    示例 2:

    输入: "A man, a plan, a canal: Panama"
    输出: "amanaP :lanac a ,nalp a ,nam A"
 * ****************************************
 */
fun reverseString(s: String): String {
    var i = 0
    var j = s.length - 1
    var temp: Char
    val strArr = s.toCharArray()
    while (i < j) {
        if (strArr[i] != strArr[j]) {
            temp = strArr[j]
            strArr[j] = strArr[i]
            strArr[i] = temp
        }
        i++
        j--
    }
    return String(strArr)
}