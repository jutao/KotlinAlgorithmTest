package hard;

import medium.ListNodeHelper;
import medium.ListNodeHelper.ListNode;

/**
 * ****************************************
 * author：琚涛
 * time：2019/3/20
 * description：25. k个一组翻转链表
 * 给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
 * ****************************************
 */
public class ReverseKGroup {
    public static void main(String[] args) {
        ListNode listNode1 = ListNodeHelper.generateListNode(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        ListNode listNode = new ReverseKGroup().reverseKGroup(listNode1, 3);
        ListNodeHelper.printListNode(listNode);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        if (head == null) {
            return null;
        }
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        if (length == 1) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        cur = head;
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < length / k; i++) {
            for (int j = 1; j < k; j++) {
                ListNode next = cur.next;
                cur.next = next.next;
                next.next = pre.next;
                pre.next = next;
            }
            pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }
}
