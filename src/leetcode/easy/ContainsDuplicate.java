package easy;

import java.util.HashSet;

/**
 * ****************************************
 * author：琚涛
 * time：2019/2/1
 * description：217. 存在重复元素
 * 给定一个整数数组，判断是否存在重复元素。
 * <p>
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 * ****************************************
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hashSet=new HashSet<>();
        for (int num : nums) {
            if(!hashSet.add(num)){
                return true;
            }
        }
        return false;
    }
}
