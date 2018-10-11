package easy

/**
 * ****************************************
 * author：琚涛
 * time：2018/10/11
 * description：
给定一个Excel表格中的列名称，返回其相应的列序号。

例如，

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28
...
示例 1:

输入: "A"
输出: 1
示例 2:

输入: "AB"
输出: 28
示例 3:

输入: "ZY"
输出: 701
 * ****************************************
 */
fun main(args: Array<String>) {
    println(TitleToNumber.titleToNumber("ZZ"))
}
class TitleToNumber{
    companion object {
        @JvmStatic
        fun titleToNumber(s: String): Int {
            val toCharArray = s.toCharArray()
            var result=0
            var p=1
            for (value in toCharArray.size - 1 downTo 0) {
                var c = toCharArray[value]
                if(c in 'a'..'z'){
                    c -= ('a' - 'A')
                }
                var number =  c- 'A'+1
                result+=p*number

                p*=26
            }
            return result
        }
    }

}
