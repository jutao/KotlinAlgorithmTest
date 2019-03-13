package easy;

/**
 * ****************************************
 * author：琚涛
 * time：2019/3/13
 * description：83. 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * ****************************************
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            while (next != null && cur.val == next.val) {
                next = next.next;
            }
            cur.next = next;
            cur = cur.next;
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
