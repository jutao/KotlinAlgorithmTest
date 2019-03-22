package medium;

import medium.ListNodeHelper.ListNode;

/**
 * ****************************************
 * author：琚涛
 * time：2019/1/30
 * description：61. 旋转链表
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * ****************************************
 */
public class RotateRight {
    public static void main(String[] args) {
        ListNode node = ListNodeHelper.generateListNode(new int[]{1, 2, 3, 4, 5});
        ListNode node1 = new RotateRight().rotateRight(node, 1);
        ListNodeHelper.printListNode(node1);
    }
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0) {
            return head;
        }
        if(head==null||head.next==null){
            return head;
        }
        int length=1;
        ListNode tail=head;
        while (tail.next!=null){
            length++;
            tail=tail.next;
        }
        k=k%length;
        if(k==0){
            return head;
        }
        ListNode slow=head;
        ListNode dummy=new ListNode(-1);
        ListNode fast;
        dummy.next=head;
        ListNode pre=dummy;
        for (int i = 1; i < length-k; i++) {
            slow=slow.next;
        }
        fast=slow.next;
        slow.next=null;
        tail.next=dummy.next;
        dummy.next=fast;
        return dummy.next;
    }
}
