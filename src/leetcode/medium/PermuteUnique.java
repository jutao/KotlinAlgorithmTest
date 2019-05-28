package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author：jutao
 * time：2019/5/28
 * description：47. 全排列 II
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 */
public class PermuteUnique {
    public static void main(String[] args) {
        List<List<Integer>> lists = new PermuteUnique().permuteUnique(new int[]{1,1,2,3,3});
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    List<List<Integer>> res;
    List<Integer> temp;
    int[] visited;

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        temp = new ArrayList<>();
        visited = new int[nums.length];
        Arrays.sort(nums);
        backtrack(nums);
        return res;
    }

    private void backtrack(int[] nums) {
        if(temp.size()==nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(visited[i]==1){
                continue;
            }
            temp.add(nums[i]);
            visited[i]=1;
            backtrack(nums);
            temp.remove(temp.size()-1);
            visited[i]=0;
            while (i+1<nums.length&&nums[i]==nums[i+1]){
                i++;
            }
        }
    }
}
