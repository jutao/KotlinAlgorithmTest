package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * author：jutao
 * time：2019/5/27
 * description：46. 全排列
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 */
public class Permute {
    List<List<Integer>> res;
    List<Integer> temp;
    int[] visited;

    public static void main(String[] args) {
        System.out.println(new Permute().permute(new int[]{1, 2,3}));
    }
    public List<List<Integer>> permute(int[] nums) {
        res=new ArrayList<>();
        temp=new ArrayList<>();
        visited=new int[nums.length];
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
            visited[i]=0;
            temp.remove(temp.size()-1);
        }
    }
}
