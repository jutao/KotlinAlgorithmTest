package medium;


/**
 * ****************************************
 * author：琚涛
 * time：2019/1/30
 * description：
 * ****************************************
 */
public class RotateRight {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0) {
            return head;
        }
        if (head == null) {
            return null;
        }
        ListNode listNode = head;
        ListNode tailNode = head;
        ListNode targetNode = head;

        int len = 0;
        while (listNode != null) {
            len++;
            tailNode = listNode;
            listNode = listNode.next;
        }
        if (k % len == 0) {
            return head;
        }
        k = len - k % len;
        if (k == 0) {
            return head;
        }
        for (int i = 1; i < k; i++) {
            targetNode = targetNode.next;
        }
        if (targetNode.next == null) {
            listNode = head;
            listNode.next = null;
            targetNode.next = listNode;
            return targetNode;

        }
        listNode = targetNode.next;
        tailNode.next = head;
        targetNode.next = null;


        return listNode;
    }
}
