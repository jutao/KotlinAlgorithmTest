package easy;

/**
 * ****************************************
 * author：琚涛
 * time：2019/1/28
 * description：14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * ****************************************
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int max = 0;
        int minLengthIndex = 0;
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < strs[minLengthIndex].length()) {
                minLengthIndex = i;
            }
        }
        while (max < strs[minLengthIndex].length()) {
            String prefix = strs[minLengthIndex].substring(0, max + 1);
            boolean isPrefix = true;
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].indexOf(prefix) != 0) {
                    isPrefix = false;
                }
            }
            if (isPrefix) {
                max++;
            } else {
                break;
            }
        }
        return strs[minLengthIndex].substring(0, max);
    }
}
