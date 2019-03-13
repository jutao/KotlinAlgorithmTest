package easy;

/**
 * ****************************************
 * author：琚涛
 * time：2019/3/12
 * description：206. 反转链表
 * 反转一个单链表。
 * ****************************************
 */
public class ReverseList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        new ReverseList().reverseList(head);
    }

    public ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;

        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
