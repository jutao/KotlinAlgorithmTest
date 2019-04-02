package medium;

import java.util.Stack;

/**
 * ****************************************
 * author：琚涛
 * time：2019/3/28
 * description：394. 字符串解码
 *
 * 给定一个经过编码的字符串，返回它解码后的字符串。编码规则为: k[encoded_string]，
 * 表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。你可以
 * 认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格
 * 式要求的。此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例
 * 如不会出现像 3a 或 2[4] 的输入。
 * ****************************************
 */
public class DecodeString {
    public static void main(String[] args) {
        System.out.println(new DecodeString().decodeString("3[a1[c1[2[abc]]]]"));
    }
    public String decodeString(String s) {
       Stack<Integer> numStack=new Stack<>();
       Stack<String> strStack=new Stack<>();
        char[] chars = s.toCharArray();
        int num=0;
        String cur = "";
        for (char ch : chars) {
            if(ch>='0'&&ch<='9'){
                num=num*10+ch-'0';
            }else if(ch=='['){
                numStack.push(num);
                num=0;
                strStack.push(cur);
                cur="";
            }else if(ch==']'){
                int multi=numStack.pop();
                String temp=strStack.pop();
                for (int i = 0; i < multi; i++) {
                    temp+=cur;
                }
                cur=temp;
            }else {
                cur+=ch;
            }
        }
        return cur;
    }
}
