package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * author：jutao
 * time：2019/6/6
 * description：784. 字母大小写全排列
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 */
public class LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        letterCasePermutation(res, S, 0, "");
        return res;
    }

    private void letterCasePermutation(List<String> res, String s, int index, String cur) {
        if (cur.length() == s.length()) {
            res.add(cur);
            return;
        }
        letterCasePermutation(res,s,index+1,cur+s.charAt(index));
        if (isWord(s.charAt(index))) {
            char tempChar=tran(s.charAt(index));
            letterCasePermutation(res,s,index+1,cur+tempChar);
        }
    }

    /**
     * 转换，大写转小写，小写转大写
     * @param c
     * @return
     */
    private char tran(char c) {
        if (c >= 'A' && c <= 'Z') {
            return (char) (c+('a'-'A'));
        }
        if (c >= 'a' && c <= 'z') {
            return (char) (c-('a'-'A'));
        }

        return 0;
    }

    private boolean isWord(char c) {
        if (c >= 'A' && c <= 'Z') {
            return true;
        }
        if (c >= 'a' && c <= 'z') {
            return true;
        }
        return false;
    }
}
