package easy;

/**
 * ****************************************
 * author：琚涛
 * time：2019/3/5
 * description：383. 赎金信
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 * <p>
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)
 * <p>
 * 注意：
 * <p>
 * 你可以假设两个字符串均只含有小写字母。
 * <p>
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 * ****************************************
 */
public class CanConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] frequency = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            frequency[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            frequency[ransomNote.charAt(i) - 'a']--;
            if (frequency[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
