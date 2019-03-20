package easy;

/**
 * ****************************************
 * author：琚涛
 * time：2019/3/19
 * description：400. 第N个数字
 * 在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 个数字。
 * <p>
 * 注意:
 * n 是正数且在32为整形范围内 ( n < 231)。
 * ****************************************
 */
public class FindNthDigit {
    public static void main(String[] args) {
        System.out.println(new FindNthDigit().findNthDigit(5));
    }

    public int findNthDigit(int n) {
        int count = 0;
        int digit = 0;
        for (int i = 1; i < 11; i++) {
            if (count + 9 * Math.pow(10, i - 1) * i >=n) {
                digit = i;
                break;
            }
            count += 9 * Math.pow(10, i - 1) * i;
        }
        int start = (int) Math.pow(10, digit - 1)-1;
        int number = n - count;
        int end = start + number / digit;
        if(number % digit==0){
            return end%10;
        }
        int remainder = digit-number % digit;
        int a=end+1;
        for (int i = 1; i <=remainder; i++) {
            a=a/10;
        }
        return a%10;
    }
}
