package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * author：jutao
 * time：2019/5/22
 * description：17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class LetterCombinations {
    List<String> list = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        String phone[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        letterCombinations(digits, phone, "");
        return list;
    }

    private void letterCombinations(String digits, String[] phone, String s) {
        if (digits.isEmpty()) {
            if (!s.isEmpty()) {
                list.add(s);
            }
            return;
        }
        int index = digits.charAt(0) - '0';
        for (char c : phone[index].toCharArray()) {
            letterCombinations(digits.substring(1), phone, s + c);
        }
    }
}
