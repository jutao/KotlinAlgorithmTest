package easy

/**
 * ****************************************
 * author：琚涛
 * time：2018/10/12
 * description：
给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。

示例:

输入: 38
输出: 2
解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
进阶:
你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？
 * ****************************************
 */
fun addDigits1(num: Int): Int {
    if (num < 10) {
        return num
    }
   var temp=num
    var result=0
    while (temp!=0){
        result+=temp%10
        temp/=10
    }
    return addDigits1(result)
}

/**
 * O(1) 时间复杂度内解决这个问题
 */
fun addDigits2(num: Int): Int {
    if (num < 10) {
        return num
    }
    return if (num % 9 == 0) {
        9
    } else {
        num % 9
    }
}