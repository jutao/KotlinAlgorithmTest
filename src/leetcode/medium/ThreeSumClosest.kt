package medium

import java.util.*

/**
 * ****************************************
 * author：琚涛
 * time：2018/9/28
 * description：给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，
 * 使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * ****************************************
 */
fun main(args: Array<String>) {
    ThreeSumClosest.threeSumClosest(intArrayOf(1,-1,3,4),2)
}
class ThreeSumClosest{
    companion object {
        @JvmStatic
        fun threeSumClosest(nums: IntArray, target: Int): Int {
            Arrays.sort(nums)

            return 3
        }
    }
}