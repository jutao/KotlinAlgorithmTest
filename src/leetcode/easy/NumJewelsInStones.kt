package leetcode.easy

fun main(args: Array<String>) {
    println(NumJewelsInStones.numJewelsInStones("aAb", "bbbb"))
}
class NumJewelsInStones{
    companion object {
        @JvmStatic
        fun numJewelsInStones(J: String, S: String): Int {
            var num=0
            for (c in S) {
                if(J.contains(c)){
                    num++
                }
            }
            return num
        }
    }
}