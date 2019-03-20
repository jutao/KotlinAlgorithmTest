package easy;

/**
 * ****************************************
 * author：琚涛
 * time：2019/3/19
 * description：367. 有效的完全平方数
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 * ****************************************
 */
public class IsPerfectSquare {
    public static void main(String[] args) {
        System.out.println(new IsPerfectSquare().isPerfectSquare(81));
    }
    public boolean isPerfectSquare(int num) {
        return num > 0 && 1162261467%num == 0;
    }
}
