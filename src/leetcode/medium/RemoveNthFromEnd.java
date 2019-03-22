package medium;

import medium.ListNodeHelper.ListNode;
/**
 * ****************************************
 * author：琚涛
 * time：2019/3/21
 * description：19. 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * ****************************************
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode node = ListNodeHelper.generateListNode(new int[]{1, 2, 3, 4, 5, 6, 4, 2, 3});
        ListNode node1 = new RemoveNthFromEnd().removeNthFromEnd(node, 0);
        ListNodeHelper.printListNode(node1);

    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode p=dummy;
        ListNode q=head;
        for (int i = 1; i <=n; i++) {
            q=q.next;
        }
        while (q!=null){
            q=q.next;
            p=p.next;
        }
        p.next=p.next.next;
        return dummy.next;
    }
}
