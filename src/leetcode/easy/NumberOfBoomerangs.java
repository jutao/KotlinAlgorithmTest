package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * ****************************************
 * author：琚涛
 * time：2019/2/27
 * description：447. 回旋镖的数量
 * 给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
 * <p>
 * 找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。
 * ****************************************
 */
public class NumberOfBoomerangs {
    public static void main(String[] args) {
        System.out.println(new NumberOfBoomerangs().numberOfBoomerangs(new int[][]{{0, 0}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}}));
    }

    public int numberOfBoomerangs(int[][] points) {
        int res=0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if(i==j){
                    continue;
                }
                int dis = getDis(points[i], points[j]);
                if (map.get(dis) == null) {
                    map.put(dis, 1);
                } else {
                    res+=map.get(dis)*2;
                    map.put(dis, map.get(dis) + 1);
                }
            }
            map.clear();
        }
        return res;
    }

    private int getDis(int[] point, int[] point1) {
        return (point[0] - point1[0]) * (point[0] - point1[0]) + (point[1] - point1[1]) * (point[1] - point1[1]);
    }
}
