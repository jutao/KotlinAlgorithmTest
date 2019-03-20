package easy;

/**
 * ****************************************
 * author：琚涛
 * time：2019/3/19
 * description：342. 4的幂
 * 给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
 * ****************************************
 */
public class IsPowerOfFour {
    public boolean isPowerOfFour(int num) {
        while (num % 4 == 0) {
            num /= 4;
        }
        return num == 0;
    }
}
