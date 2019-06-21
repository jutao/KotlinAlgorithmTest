package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * author：jutao
 * time：2019/6/21
 * description：728. 自除数
 * 自除数 是指可以被它包含的每一位数除尽的数。
 *
 * 例如，128 是一个自除数，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 *
 * 还有，自除数不允许包含 0 。
 *
 * 给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。
 */
public class SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for(int i=left; i<=right; i++){
            if(isSelfDividingNum(i)) res.add(i);
        }
        return res;
    }
    public boolean isSelfDividingNum(int n){
        int x = n;
        while(x > 0){
            int d = x%10;
            if(d==0 || n%d!=0) return false;
            x /= 10;
        }
        return true;
    }
}
