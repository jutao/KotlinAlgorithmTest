package medium;

import medium.ListNodeHelper.ListNode;

/**
 * ****************************************
 * author：琚涛
 * time：2019/3/19
 * description：82. 删除排序链表中的重复元素 II
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * ****************************************
 */
public class DeleteDuplicates {
    public static void main(String[] args) {
        ListNode listNode = ListNodeHelper.generateListNode(new int[]{1, 1, 1, 1,2,3,3,3,3});
        ListNode listNode1 = new DeleteDuplicates().deleteDuplicates(listNode);
        ListNodeHelper.printListNode(listNode1);
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy.next;
        ListNode pre = dummy;
        int count=1;
        while (cur != null) {
            ListNode next = cur.next;
            count = 1;
            while (next != null && next.val == cur.val) {
                count++;
                next = next.next;
            }
            if (count == 1) {
                pre.next = cur;
                pre = cur;
                cur = cur.next;
            } else {
                cur = next;
            }
        }
        if (count!=1){
            pre.next=null;
        }
        return dummy.next;
    }
}
