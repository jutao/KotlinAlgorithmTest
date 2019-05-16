package leetcode.easy;

/**
 * author：jutao
 * time：2019/5/16
 * description：551. 学生出勤记录 I
 * 给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符：
 * <p>
 * 'A' : Absent，缺勤
 * 'L' : Late，迟到
 * 'P' : Present，到场
 * 如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
 * <p>
 * 你需要根据这个学生的出勤记录判断他是否会被奖赏。
 */
public class CheckRecord {
    public boolean checkRecord(String s) {
        int ANumber = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                ANumber++;
                if (ANumber > 1) {
                    return false;
                }
            }else if(s.charAt(i)=='L'){
                if(i>1&&s.charAt(i-1)=='L'&&s.charAt(i-2)=='L'){
                    return false;
                }
            }
        }
        return true;
    }
}
