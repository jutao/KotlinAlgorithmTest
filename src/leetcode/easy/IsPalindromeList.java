package easy;

import medium.ListNodeHelper;
import medium.ListNodeHelper.ListNode;

/**
 * ****************************************
 * author：琚涛
 * time：2019/3/21
 * description：234. 回文链表
 * 请判断一个链表是否为回文链表。
 * ****************************************
 */
public class IsPalindromeList {
    public static void main(String[] args) {
        ListNode node = ListNodeHelper.generateListNode(new int[]{1,2,3,4,2,1});
        System.out.println(new IsPalindromeList().isPalindrome(node));

    }
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null){
            return true;
        }

        ListNode slow=head;
        ListNode fast=head;
        while (fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode right=reverse(slow.next);
        while (right!=null){
            if (right.val!=head.val) {
                return false;
            }
            right=right.next;
            head=head.next;
        }
        return true;
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
