package easy;

/**
 * ****************************************
 * author：琚涛
 * time：2019/3/1
 * description：374. 猜数字大小
 * 我们正在玩一个猜数字游戏。 游戏规则如下：
 * 我从 1 到 n 选择一个数字。 你需要猜我选择了哪个数字。
 * 每次你猜错了，我会告诉你这个数字是大了还是小了。
 * 你调用一个预先定义好的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）：
 * <p>
 * -1 : 我的数字比较小
 * 1 : 我的数字比较大
 * 0 : 恭喜！你猜对了！
 * ****************************************
 */
public abstract class GuessNumber {
    public int guessNumber(int n) {
        int l = 1;
        int h = n;
        int mid=0;
        while (l <= h) {
             mid = l + (h - l) / 2;
            if (guess(mid) == 0) {
                break;
            }
            if (guess(mid) == -1) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return mid;
    }

    public abstract int guess(int num);
}
