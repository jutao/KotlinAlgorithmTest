package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * ****************************************
 * author：琚涛
 * time：2019/2/25
 * description：454. 四数相加 II
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 * <p>
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 * ****************************************
 */
public class FourSumCount {
    public static void main(String[] args) {
        System.out.println(new FourSumCount().fourSumCount(new int[]{-1, -1}, new int[]{-1, 1}, new int[]{-1, 1}, new int[]{1, -1}));
    }
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                if (map.get(a + b) == null) {
                    map.put(a + b, 1);
                } else {
                    map.put(a + b, map.get(a + b) + 1);
                }
            }
        }
        for (int c : C) {
            for (int d : D) {
                int target = 0 - c - d;
                if (map.get(target) != null) {
                    res+=map.get(target);
                }
            }

        }
        return res;
    }
}
