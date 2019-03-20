package medium;

import medium.ListNodeHelper.ListNode;

/**
 * ****************************************
 * author：琚涛
 * time：2019/3/20
 * description：24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * ****************************************
 */
public class SwapPairs {
    public static void main(String[] args) {
        ListNode listNode1 = ListNodeHelper.generateListNode(new int[]{1,2});
        ListNode listNode = new SwapPairs().swapPairs(listNode1);
        ListNodeHelper.printListNode(listNode);
    }
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            ListNode node1 = cur;
            ListNode node2 = cur.next;
            cur = node2.next;
            p.next = node2;
            node2.next = node1;
            node1.next = cur;
            p = node1;
        }
        return dummy.next;
    }
}
