package medium;

import medium.ListNodeHelper.ListNode;

/**
 * ****************************************
 * author：琚涛
 * time：2019/3/18
 * description：86. 分隔链表
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 * ****************************************
 */
public class ListNodePartition {
    public static void main(String[] args) {
        ListNode listNode = ListNodeHelper.generateListNode(new int[]{16,1,17,2,18,3});
        ListNode partition = new ListNodePartition().partition(listNode, 5);
        ListNodeHelper.printListNode(partition);
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode bigList = null;
        ListNode bigHead = null;
        ListNode smallList = null;
        ListNode smallHead = null;

        while (head != null) {
            if (head.val < x) {
                if (smallHead == null) {
                    smallHead = new ListNode(head.val);
                    smallList = smallHead;
                } else {
                    smallList.next = new ListNode(head.val);
                    smallList = smallList.next;
                }
            } else {
                if (bigHead == null) {
                    bigHead = new ListNode(head.val);
                    bigList = bigHead;
                } else {
                    bigList.next = new ListNode(head.val);
                    bigList = bigList.next;
                }
            }
            head = head.next;
        }
        if (smallHead == null) {
            return bigHead;
        }
        smallList.next = bigHead;
        return smallHead;
    }
}
