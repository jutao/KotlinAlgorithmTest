package medium;

import medium.ListNodeHelper.ListNode;

/**
 * ****************************************
 * author：琚涛
 * time：2019/3/20
 * description：147. 对链表进行插入排序
 * 对链表进行插入排序。
 * ****************************************
 */
public class InsertionSortList {
    public static void main(String[] args) {
        int[] arr = new int[]{5};
        ListNodeHelper.ListNode listNode = ListNodeHelper.generateListNode(arr);
        ListNode listNode1 = new InsertionSortList().insertionSortList(listNode);
        ListNodeHelper.printListNode(listNode1);
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head;
        ListNode preNode = dummy;
        while (cur != null) {
            ListNode node = cur;
            ListNode cy = dummy.next;
            ListNode pre = dummy;
            while (cy != node && cy.val < node.val) {
                pre = cy;
                cy = cy.next;
            }
            if (cy != node) {
                preNode.next = node.next;
                ListNode nex = pre.next;
                pre.next = node;
                node.next = nex;
                cur = preNode.next;
                continue;
            }
            preNode = cur;
            cur = cur.next;
        }
        return dummy.next;
    }

    public void insertionSortArr(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            int temp = arr[i];
            while (j > 0 && temp < arr[j - 1]) {
                arr[j] = arr[--j];
            }
            arr[j] = temp;
        }
    }
}
