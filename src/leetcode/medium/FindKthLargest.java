package medium;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * ****************************************
 * author：琚涛
 * time：2019/1/4
 * description：215. 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 * <p>
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 * ****************************************
 */
public class FindKthLargest {
    public static void main(String[] args) {
        int[] arr = {1};
        System.out.println(new FindKthLargest().findKthLargest1(arr, 1));
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int num : nums) {
            if (priorityQueue.size() == k && priorityQueue.peek() < num) {
                priorityQueue.poll();
            }
            if (priorityQueue.size() < k) {
                priorityQueue.add(num);
            }
        }
        return priorityQueue.poll();
    }

    public  int findKthLargest1(int[] nums, int k) {
        int target=nums.length-k;
        int result=-1;
        int l=0;
        int r=nums.length-1;
        while (result!=target){
            result=partition(nums, l, r);
            if(result>target){
                r=result-1;
            }else {
                l=result+1;
            }
        }
        return nums[target];
    }

    private  int partition(int[] nums, int l, int r) {
        swap(nums, l, new Random().nextInt(r - l + 1) + l);
        int v = nums[l];
        int i = l + 1;
        int j = r;
        while (true) {
            while (i <= r && nums[i] < v) {
                i++;
            }
            while (j > l && nums[j] > v) {
                j--;
            }
            if (i > j) {
                break;
            }
            swap(nums, i, j);
            i++;
            j--;
        }
        swap(nums,j,l);
        return j;
    }

    /**
     * 交换arr数组的第i个和第j个元素
     */
    private  void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
