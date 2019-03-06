package easy;

import java.util.Stack;

/**
 * ****************************************
 * author：琚涛
 * time：2019/3/4
 * description：682. 棒球比赛
 * 你现在是棒球比赛记录员。
 * 给定一个字符串列表，每个字符串可以是以下四种类型之一：
 * 1.整数（一轮的得分）：直接表示您在本轮中获得的积分数。
 * 2. "+"（一轮的得分）：表示本轮获得的得分是前两轮有效 回合得分的总和。
 * 3. "D"（一轮的得分）：表示本轮获得的得分是前一轮有效 回合得分的两倍。
 * 4. "C"（一个操作，这不是一个回合的分数）：表示您获得的最后一个有效 回合的分数是无效的，应该被移除。
 * <p>
 * 每一轮的操作都是永久性的，可能会对前一轮和后一轮产生影响。
 * 你需要返回你在所有回合中得分的总和。
 * ****************************************
 */
public class CalPoints {
    public static void main(String[] args) {
        System.out.println(new CalPoints().calPoints(new String[]{"5", "2", "C", "D", "+"}));
    }
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (String op : ops) {
            switch (op) {
                case "+":
                    Integer pop = stack.pop();
                    int point=pop + stack.peek();
                    sum += point;
                    stack.push(pop);
                    stack.push(point);
                    break;
                case "D":
                    stack.push(stack.peek() * 2);
                    sum += stack.peek();
                    break;
                case "C":
                    sum -= stack.pop();
                    break;
                default:
                    int pointw=Integer.valueOf(op);
                    sum+=pointw;
                    stack.push(pointw);
                    break;
            }
        }
        return sum;
    }
}
