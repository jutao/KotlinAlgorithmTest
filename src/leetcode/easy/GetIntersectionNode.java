package easy;

import medium.ListNodeHelper.ListNode;

/**
 * ****************************************
 * author：琚涛
 * time：2019/3/26
 * description：160. 相交链表
 * 编写一个程序，找到两个单链表相交的起始节点
 * ****************************************
 */
public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while(pA != pB){
            pA = pA == null ? headA : pA.next;
            pB = pB == null ? headB: pB.next;
        }
        return pA;
    }
}
