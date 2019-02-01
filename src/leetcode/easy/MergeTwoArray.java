package easy;

/**
 * ****************************************
 * author：琚涛
 * time：2019/2/1
 * description：88. 合并两个有序数组
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 * ****************************************
 */
public class MergeTwoArray {
    public static void main(String[] args) {
        MergeTwoArray mergeTwoArray = new MergeTwoArray();
        int[] ints = {4, 0, 0, 0, 0, 0};
        mergeTwoArray.merge(ints, 1, new int[]{1,2,3,5,6}, 5);
        for (int anInt : ints) {
            System.out.print(anInt+" ");
        }
    }

    /**
     * 归并排序的思路
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int copyArr[] = new int[m + n];
        for (int i = 0; i < m; i++) {
            copyArr[i] = nums1[i];
        }

        for (int i = m; i < m + n; i++) {
            copyArr[i] = nums2[i - m];
        }
        int i = 0;

        int j = m;
        for (int k = 0; k < m + n; k++) {
            if (i >=m) {
                nums1[k] = copyArr[j++];
            } else if (j >= m + n) {
                nums1[k] = copyArr[i++];
            } else if (copyArr[i] > copyArr[j]) {
                nums1[k] = copyArr[j++];
            } else if (copyArr[i] <= copyArr[j]) {
                nums1[k] = copyArr[i++];
            }
        }
    }
}
