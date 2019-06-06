package leetcode.easy;

/**
 * author：jutao
 * time：2019/6/6
 * description：191. 位1的个数
 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 */
public class HammingWeight {
    public static void main(String[] args) {
        System.out.println(new HammingWeight().hammingWeight(00000000000000000000000000001011));
        System.out.println(new HammingWeight().hammingWeight1(00000000000000000000000000001011));
    }
    public int hammingWeight(int n) {
            int count =0;
            while (n!=0){
                if((n&1)==1){
                    count++;
                }
                n>>>=1;
            }
            return count;
    }

    public int hammingWeight1(int n) {
        return Integer.bitCount(n);
    }
}
