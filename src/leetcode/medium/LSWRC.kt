package medium

/**
 * ****************************************
 * author：琚涛
 * time：2018/9/28
 * description：Given a string, find the length of the longest substring without repeating characters.
 * Example 1:
 *  Input: "abcabcbb"
 *  Output: 3
 *  Explanation: The answer is "abc", with the length of 3.
 * ****************************************
 */
fun main(args: Array<String>) {
    println(LSWRC.lengthOfLongestSubstring("abcabcd"))
}

class LSWRC {
    companion object {
        @JvmStatic
        fun lengthOfLongestSubstring(s: String): Int {
            var ans=0
            val set:HashSet<Char> = hashSetOf()
            val n=s.length
            var i=0
            var j=0
            while (i<n&&j<n){
                if(!set.contains(s[j])){
                    set.add(s[j++])
                    ans=Math.max(ans,j-i)
                }else{
                    set.remove(s[i++])
                }
            }
            return ans
        }
    }
}