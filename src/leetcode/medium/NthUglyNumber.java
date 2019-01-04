package medium;

/**
 * ****************************************
 * author：琚涛
 * time：2019/1/4
 * description：264. 丑数 II
 * 编写一个程序，找出第 n 个丑数。
 * <p>
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:
 * <p>
 * 1 是丑数。
 * n 不超过1690。
 * ****************************************
 */
public class NthUglyNumber {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }

    public static int nthUglyNumber(int n) {

        int[] arr = new int[n];
        int k1 = 0;
        int k2 = 0;
        int k3 = 0;
        int index = 1;
        arr[0] = 1;
        while (index < n) {
            int a = arr[k1] * 2;
            int b = arr[k2] * 3;
            int c = arr[k3] * 5;
            int min = Math.min(Math.min(a, b), c);

            arr[index] = min;
            if (arr[index] == arr[k1] * 2) {
                k1++;
            }
            if (arr[index] == arr[k2] * 3) {
                k2++;
            }
            if (arr[index] == arr[k3] * 5) {
                k3++;
            }
            index++;
        }

        return arr[n - 1];
    }


}
