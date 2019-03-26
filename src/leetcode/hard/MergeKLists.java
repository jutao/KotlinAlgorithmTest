package hard;

import medium.ListNodeHelper;
import medium.ListNodeHelper.ListNode;
/**
 * ****************************************
 * author：琚涛
 * time：2019/3/26
 * description：23. 合并K个排序链表
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * ****************************************
 */
public class MergeKLists {
    public static void main(String[] args) {
        ListNode node1 = ListNodeHelper.generateListNode(new int[]{});
        ListNode node2 = ListNodeHelper.generateListNode(new int[]{});
        ListNode node3 = ListNodeHelper.generateListNode(new int[]{});
        ListNode node4 = ListNodeHelper.generateListNode(new int[]{});
        ListNode[] listNodes={node1,node2,node3,node4};
        ListNode node = new MergeKLists().mergeKLists(listNodes);
        ListNodeHelper.printListNode(node);
    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummyHead=new ListNode(-1);
        ListNode cur=dummyHead;
        for (int i = 0; i < lists.length; i++) {
            cur.next=lists[i];
            while (cur.next!=null){
                cur=cur.next;
            }
        }
        ListNode mergeSort=mergeSort(dummyHead.next);
        return mergeSort;
    }

    private ListNode mergeSort(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode fast=head;
        ListNode slow=head;
        ListNode pre=null;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            pre=slow;
            slow=slow.next;
        }
        pre.next=null;
        ListNode l=mergeSort(head);
        ListNode r=mergeSort(slow);

        return merge(l,r);
    }

    private ListNode merge(ListNode l, ListNode r) {
        ListNode dummy=new ListNode(-1);
        ListNode cur=dummy;
        while (l!=null&&r!=null){
            if(l.val<r.val){
                cur.next=l;
                l=l.next;
            }else {
                cur.next=r;
                r=r.next;
            }
            cur=cur.next;
        }
        if(l!=null){
            cur.next=l;
        }
        if(r!=null){
            cur.next=r;
        }
        return dummy.next;
    }
}
