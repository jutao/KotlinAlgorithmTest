package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * author：jutao
 * time：2019/6/4
 * description：401. 二进制手表
 * 二进制手表顶部有 4 个 LED 代表小时（0-11），底部的 6 个 LED 代表分钟（0-59）。
 * 每个 LED 代表一个 0 或 1，最低位在右侧。
 * 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。
 */
public class ReadBinaryWatch {

    public List<String> readBinaryWatch(int num) {
        List<String> ret = new ArrayList<String>();
        for (int hour = 0; hour < 12; hour++) {
            for (int minute = 0; minute < 60; minute++) {
                //在右边补6个0，避免重复位或
                if (Integer.bitCount(hour << 6 | minute) == num) {
                    ret.add(hour + (minute < 10 ? ":0" : ":") + minute);
                }
            }
        }
        return ret;
    }

//    解法2
//    final int[] HOUR = {8, 4, 2, 1};
//    final int MAX_HOUR = 11;
//    final int[] MINUTE = {32, 16, 8, 4, 2, 1};
//    final int MAX_MINUTE = 59;
//    List<String> res;
//
//    public List<String> readBinaryWatch(int num) {
//        res = new ArrayList<>();
//        for (int i = 0; i <= Math.min(num,3); i++) {
//            int j = num - i;
//            readBinaryWatch(i, j);
//        }
//        return res;
//    }
//
//    private void readBinaryWatch(int hourCount, int minuteCount) {
//        List<Integer> hours=new ArrayList<>();
//        getHour(hourCount,hours,0,0);
//        List<Integer> minutes=new ArrayList<>();
//        getMinute(minuteCount,minutes,0,0);
//        for (Integer hour : hours) {
//            for (Integer minute : minutes) {
//                res.add(hour+(minute<10?":0":":")+minute);
//            }
//        }
//    }
//
//    private void getMinute(int minuteCount, List<Integer> minutes, int minute,int start) {
//        if(minuteCount==0){
//            if(minute>MAX_MINUTE){
//                return;
//            }
//            minutes.add(minute);
//            return;
//        }
//        for (int i = start; i <MINUTE.length; i++) {
//            getMinute(minuteCount-1,minutes,minute+MINUTE[i],i+1);
//        }
//    }
//
//    private void getHour(int hourCount, List<Integer> hours, int hour, int start) {
//        if(hourCount==0){
//            if(hour>MAX_HOUR){
//                return;
//            }
//            hours.add(hour);
//            return;
//        }
//        for (int i = start; i <HOUR.length; i++) {
//            getHour(hourCount-1,hours,hour+HOUR[i],i+1);
//        }
//    }
}
