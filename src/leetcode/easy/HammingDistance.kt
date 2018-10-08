package easy

/**
 * ****************************************
 * author：琚涛
 * time：2018/10/8
 * description：两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。

    给出两个整数 x 和 y，计算它们之间的汉明距离。

    注意：
    0 ≤ x, y < 231.

    示例:

    输入: x = 1, y = 4

    输出: 2

    解释:
    1   (0 0 0 1)
    4   (0 1 0 0)
          ↑   ↑

    上面的箭头指出了对应二进制位不同的位置。
 * ****************************************
 */
fun main(args: Array<String>) {
    println(HammingDistance.hammingDistance(16, 8))
}

class HammingDistance {

    companion object {
        @JvmStatic
        fun hammingDistance(x: Int, y: Int): Int {
            var xArray:IntArray = getBinaryArray(x)
            val yArray:IntArray = getBinaryArray(y)
            return xArray.indices.count { xArray[it]!=yArray[it] }
        }

        private fun getBinaryArray(number: Int): IntArray {
            val array=IntArray(31)
            var temp=number
            var i=0
            while (temp!=0){
                array[i++]=temp%2
                temp/=2
            }
            return array
        }
    }
}