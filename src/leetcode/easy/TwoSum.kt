package easy

/**
 * ****************************************
 * author：琚涛
 * time：2018/9/27
 * description：
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * ****************************************
 */
fun main(args: Array<String>) {
    val twoSum = TwoSum.twoSum(intArrayOf(1,3,5,6), 6)
    for (i in twoSum) {
        println(i)
    }
}
class TwoSum {

    companion object {
        @JvmStatic
        fun twoSum(nums: IntArray, target: Int): IntArray {
            val map: HashMap<Int, Int> = hashMapOf()
            for (i in nums.indices) {
                val complement: Int = target - nums[i]
                if (map.containsKey(complement)) {
                    return intArrayOf(i, map[complement]!!)
                }
                map.put(nums[i],i)
            }
            throw IllegalArgumentException("No two sum solution")
        }
    }
}
