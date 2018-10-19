package easy

/**
 * ****************************************
 * author：琚涛
 * time：2018/10/12
 * description：
 * ****************************************
 */
fun main(args: Array<String>) {
    arrayPairSum(intArrayOf(5, 6, 66, 1, 2))
}

fun arrayPairSum(nums: IntArray): Int {
    val hash = IntArray(20001)
    //桶排序
    for (i in 0 until nums.size){
        hash[10000+nums[i]]++
    }
    var odd=true
    var sum=0
    for(i in 0 until hash.size){
        while (hash[i]>0){
            if(odd){
                sum+=i-10000
            }
            odd=!odd
            hash[i]--
        }
    }
    return sum
}