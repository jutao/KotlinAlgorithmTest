package leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * 290. 单词模式
 * 给定一种 pattern(模式) 和一个字符串 str ，判断 str 是否遵循相同的模式。
 * <p>
 * 这里的遵循指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应模式。
 * <p>
 * 示例1:
 * <p>
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * <p>
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {

        String[] split = str.split(" ");
        Map<Character, String> map = new HashMap<>(pattern.length());
        if (pattern.length() != split.length) {
            return false;
        }
        for (int i = 0; i < split.length; i++) {
            char key = pattern.charAt(i);
            if (map.get(key) == null) {
                if(map.containsValue(split[i])){
                    return false;
                }else {
                    map.put(key, split[i]);
                }

            } else {
                if (!map.get(key).equals(split[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}
