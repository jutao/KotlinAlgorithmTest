package leetcode.easy


fun main(args: Array<String>) {
    println(ToLowerCase.toLowerCase("abcdeAAA"))
}

class ToLowerCase{
    companion object {
        @JvmStatic
        fun toLowerCase(str: String): String {
            val gap='a'-'A'
            val sb =StringBuilder()
            for (c in str) {
                if(c in 'A'..'Z'){
                    sb.append(c+gap)
                }else{
                    sb.append(c)
                }
            }
            return sb.toString()
        }
    }
}