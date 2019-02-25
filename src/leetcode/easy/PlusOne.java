package easy;

import java.util.ArrayList;

/**
 * ****************************************
 * author：琚涛
 * time：2019/2/25
 * description：66. 加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * ****************************************
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        if(digits.length==0){
            return new int[]{1};
        }
        ArrayList<Integer> list = new ArrayList<>();
        int plus = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + plus;
            if(i==digits.length - 1){
                sum++;
            }

            list.add(sum % 10);
            plus = sum / 10;
        }
        if(plus!=0){
            list.add(plus);
        }
        int[] res=new int[list.size()];
        for (int i = list.size()-1; i >=0; i--) {
            res[list.size()-i-1]=list.get(i);
        }
        return res;
    }
}
