package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * author：jutao
 * time：2019/5/27
 * description：131. 分割回文串
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * <p>
 * 返回 s 所有可能的分割方案。
 */
public class PartitionRecursion {
    public static void main(String[] args) {
        System.out.println(new PartitionRecursion().partition("aab") + "");
    }

    List<List<String>> list;
    List<String> temp;

    public List<List<String>> partition(String s) {
        list = new ArrayList<>();
        temp = new ArrayList<>();
        partition(s, 0);
        return list;
    }

    private void partition(String s, int index) {
        if (s.length() == index) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index+1; i <= s.length(); i++) {
            if (isPalindrome(s,index,i-1)) {
                temp.add(s.substring(index,i));
                partition(s,i);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s,int start,int end) {
        int i = start;
        int j = end;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
