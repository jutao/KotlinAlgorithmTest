package easy;

import java.util.Stack;

/**
 * ****************************************
 * author：琚涛
 * time：2019/1/18
 * description：20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * ****************************************
 */
public class IsValidBracket {
    public static void main(String[] args) {
        System.out.println(new IsValidBracket().isValid("()[(])(({[]}))"));
    }
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char ch : chars) {
            if (ch == ' ') {
                continue;
            }
            if (stack.isEmpty()) {
                stack.push(ch);
                continue;
            }
            if (isPair(stack.peek(),ch)) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }

    /**
     * 如果是一对儿
     * @param front 前
     * @param back 后
     * @return
     */
    private boolean isPair(char front, char back) {
        if(front=='('&&back==')'){
            return true;
        }
        if(front=='{'&&back=='}'){
            return true;
        }
        if(front=='['&&back==']'){
            return true;
        }
        return false;

    }
}
