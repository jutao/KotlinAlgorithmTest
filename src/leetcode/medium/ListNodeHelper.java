package medium;

/**
 * ****************************************
 * author：琚涛
 * time：2019/3/18
 * description：ListNode辅助类
 * ****************************************
 */
public class ListNodeHelper {

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    /**
     * 生成一个链表
     *
     * @param arr
     * @return
     */
    public static ListNode generateListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head;
    }

    /**
     * 打印链表
     *
     * @param node
     */
    public static void printListNode(ListNode node) {
        while (node != null) {
            System.out.print(node.val + "-->");
            node = node.next;
        }
        System.out.print("NULL");
    }
}
