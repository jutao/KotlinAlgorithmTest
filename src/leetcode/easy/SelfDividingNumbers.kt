package easy

/**
 * ****************************************
 * author：琚涛
 * time：2018/10/11
 * description：自除数 是指可以被它包含的每一位数除尽的数。

    例如，128 是一个自除数，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。

    还有，自除数不允许包含 0 。

    给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。

    示例 1：

    输入：
    上边界left = 1, 下边界right = 22
    输出： [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 * ****************************************
 */
fun selfDividingNumbers(left: Int, right: Int): List<Int> {
    val list:ArrayList<Int> = arrayListOf()
    if (right < 10){
        list += left..right
        return list
    }
    (left .. right).filterTo(list) { isSelfDividingNumbers(it) }
    return list
}

fun isSelfDividingNumbers(number: Int): Boolean {
    var temp=number
    var remainder:Int
    while (temp!=0){
        remainder=temp%10
        if(remainder==0){
            return false
        }
        if(number%remainder!=0){
            return false
        }
        temp/=10
    }
    return true
}
