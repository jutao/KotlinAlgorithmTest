package medium;

/**
 * ****************************************
 * author：琚涛
 * time：2019/1/28
 * description：11.盛水最多的容器
 * ****************************************
 */
public class MaxArea {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            maxArea = Math.max(maxArea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }
        return maxArea;
    }
}
