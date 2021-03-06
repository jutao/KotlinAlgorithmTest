package easy;

/**
 * ****************************************
 * author：琚涛
 * time：2019/2/26
 * description：387. 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 * 案例:
 * <p>
 * s = "leetcode"
 * 返回 0.
 * <p>
 * s = "loveleetcode",
 * 返回 2.
 * ****************************************
 */
public class FirstUniqChar {
    public int firstUniqChar(String s) {
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if(map[s.charAt(i) - 'a']==1){
                return i;
            }
        }
        return -1;
    }
}
