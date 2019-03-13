package medium;

/**
 * ****************************************
 * author：琚涛
 * time：2019/3/12
 * description：92. 反转链表 II
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * ****************************************
 */
public class ReverseBetween {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        new ReverseBetween().reverseBetween(head, 1, 2);
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m >= n || head == null || head.next == null) {
            return head;
        }
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode preNode = fakeHead;
        int i = 1;
        while (i++ < m && preNode != null) {
            preNode = preNode.next;
        }
        if (preNode == null || preNode.next == null) {
            return fakeHead;
        }
        head = preNode.next;
        i = m;
        ListNode next = null;
        ListNode newTail = head;
        ListNode newHead = null;
        while (head != null && i <= n) {
            next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
            i++;
        }

        preNode.next = newHead;
        newTail.next = head;
        return fakeHead.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
