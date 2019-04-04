package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * ****************************************
 * author：琚涛
 * time：2019/4/3
 * description：118. 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * ****************************************
 */
public class PascalTriangleGenerate {
    public static void main(String[] args) {
        List<List<Integer>> generate = new PascalTriangleGenerate().generate(15);
        int row=0;
        for (List<Integer> list : generate) {
            for (int i = 0; i <=generate.size() - row; i++) {
                System.out.print(" ");
            }
            for (Integer integer : list) {
                System.out.print(integer+"  ");
            }
            System.out.println();
            row++;
        }
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList<>();
        if(numRows==0){
            return res;
        }
        List<Integer> list1=new ArrayList<>();
        list1.add(1);
        res.add(list1);
        if(numRows==1){
            return res;
        }
        List<Integer> list2=new ArrayList<>();
        list2.add(1);
        list2.add(1);
        res.add(list2);
        if(numRows==2){
            return res;
        }
        for (int i = 3; i <= numRows; i++) {
            List<Integer> list=new ArrayList<>();
            List<Integer> last = res.get(i - 2);
            for (int j = 0; j < i; j++) {
                if(j==0||j==i-1){
                    list.add(1);
                }else {
                    list.add(last.get(j-1)+last.get(j));
                }
            }
            res.add(list);
        }
        return res;
    }
}
