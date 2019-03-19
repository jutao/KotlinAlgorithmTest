package easy;

import medium.ListNodeHelper;
import medium.ListNodeHelper.ListNode;

/**
 * ****************************************
 * author：琚涛
 * time：2019/3/5
 * description：203. 移除链表元素
 * 删除链表中等于给定值 val 的所有节点。
 * ****************************************
 */
public class RemoveElements {
    public static void main(String[] args) {
        ListNode listNode = ListNodeHelper.generateListNode(new int[]{1, 1, 1, 11, 2, 6, 3, 4, 5, 6,6,6,6,6,6});
        ListNode listNode1 = new RemoveElements().removeElements(listNode, 6);
        ListNodeHelper.printListNode(listNode1);

    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy.next;
        ListNode last = dummy;
        while (cur != null) {
            if (cur.val == val) {
                last.next = cur.next;
                cur = cur.next;
                continue;
            }
            last = cur;
            cur = cur.next;
        }
        return dummy.next;
    }

}



