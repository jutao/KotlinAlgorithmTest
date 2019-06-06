package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * author：jutao
 * time：2019/6/6
 * description：22. 括号生成
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateParenthesis(n, res, 0, 0, "");
        return res;
    }

    private void generateParenthesis(int n, List<String> res, int left, int right, String cur) {
        if (cur.length() == 2 * n) {
            res.add(cur);
            return;
        }
        if (left < n) {
            generateParenthesis(n, res, left + 1, right, cur + '(');
        }
        if (right < left) {
            generateParenthesis(n, res, left, right + 1, cur + ')');
        }
    }
}
