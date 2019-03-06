package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * ****************************************
 * author：琚涛
 * time：2019/3/5
 * description：414. 第三大的数
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 * ****************************************
 */
public class ThirdMax {
    public static void main(String[] args) {
        System.out.println(new ThirdMax().thirdMax(new int[]{-2147483648,1,1}));
    }

    public int thirdMax(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            boolean flag = false;
            for (Integer integer : list) {
                if (integer == num) {
                    flag = true;
                }
            }
            if (flag) {
                continue;
            }
            if (list.size() <= 2) {
                list.add(num);
                Collections.sort(list, (o1, o2) -> {
                    if(Objects.equals(o2, o1)){
                        return 0;
                    }else if(o2<o1){
                        return -1;
                    }else {
                        return 1;
                    }
                });
            } else {
                if (num > list.get(0)) {
                    list.set(2, list.get(1));
                    list.set(1, list.get(0));
                    list.set(0, num);
                } else if (num > list.get(1)) {
                    list.set(2, list.get(1));
                    list.set(1, num);
                } else if (num > list.get(2)) {
                    list.set(2, num);
                }
            }

        }
        if (list.size() < 3) {
            return list.get(0);
        } else {
            return list.get(2);
        }
    }
}
