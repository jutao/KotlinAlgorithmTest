package easy;

/**
 * ****************************************
 * author：琚涛
 * time：2019/1/3
 * description：703. 数据流中的第K大元素
 * 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
 * <p>
 * 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返回当前数据流中第K大的元素。
 * <p>
 * 示例:
 * <p>
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 * 说明:
 * 你可以假设 nums 的长度≥ k-1 且k ≥ 1。
 * ****************************************
 */
public class KthLargest {

    private int k;
    private int count = 0;
    private int[] data;

    public static void main(String[] args) {
        int k = 3;
        int[] arr = {4,5,8,2};
        KthLargest kthLargest=new KthLargest(k,arr);
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(0));
    }
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.data = new int[k + 1];
        for (int num : nums) {
            add(num);
        }
    }

    public void shiftUp(int index) {
        while (index > 1 && data[index / 2] > data[index]) {
            swap(data, index / 2, index);
            index /= 2;
        }
    }

    public int add(int val) {
        //如果当前数量已经大于最大堆范围并且小于当前最大的数
        if (count ==k&&val>data[1]) {
            //堆顶出队
            pop();
        }
        if(count<k){
            data[++count]=val;
            shiftUp(count);
        }


        return data[1];
    }


    /**
     * 弹出队顶
     *
     * @return
     */
    private int pop() {
        if (count <= 0) {
            return 0;
        }
        int ret = data[1];
        swap(data, count, 1);
        count--;
        shiftDown(1);
        return ret;
    }

    private void shiftDown(int i) {
        while (i * 2 <= count) {
            int j = i * 2;
            if (j + 1 <= count && data[j] >data[j+1]) {
                j += 1;
            }
            if (data[i] <= data[j]) {
                break;
            }
            swap(data, i, j);
            i = j;
        }
    }


    /**
     * 交换arr数组的第i个和第j个元素
     */
    private void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
