package easy;

/**
 * ****************************************
 * author：琚涛
 * time：2019/1/25
 * description：441. 排列硬币
 * 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
 * <p>
 * 给定一个数字 n，找出可形成完整阶梯行的总行数。
 * <p>
 * n 是一个非负整数，并且在32位有符号整型的范围内。
 * 示例 1:
 * <p>
 * n = 5
 * <p>
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤
 * <p>
 * 因为第三行不完整，所以返回2.
 * 示例 2:
 * <p>
 * n = 8
 * <p>
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 * <p>
 * 因为第四行不完整，所以返回3.
 * ****************************************
 */
public class ArrangeCoins {
    public static void main(String[] args) {
        System.out.println(new ArrangeCoins().arrangeCoins(1804289383));
    }
    public int arrangeCoins(int n) {
        long l = 0;
        long r = n;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            long sum = (1 + mid) * mid/2;
            long sumPlus = (1 + mid + 1) * (mid + 1) / 2;
            if (n >= sum && n < sumPlus) {
                return (int) mid;
            } else if (sum < n) {
                l=mid+1;
            } else{
                r=mid-1;
            }
        }
        return 0;
    }


}
