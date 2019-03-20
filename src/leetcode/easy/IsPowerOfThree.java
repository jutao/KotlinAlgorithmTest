package easy;

/**
 * ****************************************
 * author：琚涛
 * time：2019/3/19
 * description：326. 3的幂
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 * ****************************************
 */
public class IsPowerOfThree {
    public static void main(String[] args) {
        System.out.println(new IsPowerOfThree().isPowerOfThree(333));
    }

    public boolean isPowerOfThree(int n) {
        if (n == 0) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
