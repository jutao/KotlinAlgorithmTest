package easy;

/**
 * ****************************************
 * author：琚涛
 * time：2019/3/5
 * description：389. 找不同
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * <p>
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * <p>
 * 请找出在 t 中被添加的字母。
 * ****************************************
 */
public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        char ch = cht[0];
        for (int i = 0; i < chs.length; i++) {
            ch ^= chs[i];
            ch ^= cht[i + 1];
        }
        return ch;
    }
}
