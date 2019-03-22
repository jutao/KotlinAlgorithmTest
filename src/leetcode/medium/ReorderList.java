package medium;

import medium.ListNodeHelper.ListNode;
/**
 * ****************************************
 * author：琚涛
 * time：2019/3/22
 * description：143. 重排链表
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * ****************************************
 */
public class ReorderList {
    public static void main(String[] args) {
        ListNode node = ListNodeHelper.generateListNode(new int[]{1, 2, 3, 4, 5,6,7,8,9,10});
        new ReorderList().reorderList(node);
        ListNodeHelper.printListNode(node);
    }
    public void reorderList(ListNode head) {
        if(head==null||head.next==null){
            return;
        }
        //截取后一半
        ListNode slow=head;
        ListNode fast=head;
        while (fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        fast=slow.next;
        slow.next=null;
        //翻转
        ListNode reverse = reverse(fast);
        ListNode cur=head;
        ListNode rCur=reverse;
        //拼接
        while (cur!=null&&rCur!=null){
            ListNode next=cur.next;
            ListNode rNext=rCur.next;
            cur.next=rCur;
            rCur.next=next;
            cur=next;
            rCur=rNext;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode pre=null;
        ListNode cur=head;
        ListNode next=null;
        while (cur!=null){
            next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }
}
