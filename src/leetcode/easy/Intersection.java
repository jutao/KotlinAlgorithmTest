package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ****************************************
 * author：琚涛
 * time：2019/1/25
 * description：349. 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 示例 2:
 * <p>
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 说明:
 * <p>
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 * ****************************************
 */
public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map=new HashMap<>(nums1.length);
        int[] num;
        int[] find;
        if(nums1.length>nums2.length){
            num=nums2;
            find=nums1;
        }else {
            num=nums1;
            find=nums2;
        }
        for (int i = 0; i < num.length; i++) {
            map.put(num[i],0);
        }
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < find.length; i++) {
            if (list.contains(find[i])) {
                continue;
            }
            if (map.get(find[i])!=null) {
                list.add(find[i]);
            }
        }
        int[] result=new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i]=list.get(i);
        }
        return result;
    }
}
