package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * ****************************************
 * author：琚涛
 * time：2019/4/3
 * description：119. 杨辉三角 II
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 * ****************************************
 */
public class PascalTriangleGetRow {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        long nk = 1;
        for(int i = 0; i <= rowIndex; i++){
            res.add((int)nk);
            nk = nk * (rowIndex - i) / (i + 1);
        }
        return res;
    }

}
