package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 202. 快乐数
 * 编写一个算法来判断一个数是不是“快乐数”。
 * <p>
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 * <p>
 * 示例:
 * <p>
 * 输入: 19
 * 输出: true
 * 解释:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 */
public class IsHappy {
    public boolean isHappy(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(n, 1);
        while (n != 1) {
            int res = decompose(n);
            if (map.get(res) != null) {
                return false;
            } else {
                map.put(res, 1);
            }
            n = res;
        }
        return true;
    }

    private int decompose(int n) {
        int result = 0;
        while (n != 0) {
            int mod = n % 10;
            result += mod * mod;
            n /= 10;
        }
        return result;
    }
}
