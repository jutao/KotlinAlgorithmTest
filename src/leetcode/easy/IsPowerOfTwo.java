package easy;

/**
 * ****************************************
 * author：琚涛
 * time：2019/2/1
 * description：231. 2的幂
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 * ****************************************
 */
public class IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if(n<1){
            return false;
        }
        return (n&(n-1))==0;
    }
}
