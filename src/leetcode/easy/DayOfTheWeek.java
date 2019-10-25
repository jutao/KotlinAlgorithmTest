package leetcode.easy;

import java.util.Calendar;

/**
 * author：jutao
 * time：2019/9/10
 * description：1185. 一周中的第几天
 * 给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。
 */
public class DayOfTheWeek {
    public static void main(String[] args) {
        System.out.println(new DayOfTheWeek().dayOfTheWeek(8, 10, 2019));
    }

    public String dayOfTheWeek(int day, int month, int year) {
        if (month == 1 || month == 2) {
           month+=12;
           year--;
        }
        int iWeek=(day+2*month+3*(month+1)/5+year+year/4-year/100+year/400)%7;
        String[] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday","Sunday"};
        return week[iWeek];
    }
}
