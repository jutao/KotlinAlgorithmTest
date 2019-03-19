package medium;

import medium.ListNodeHelper.ListNode;

import java.util.Stack;

/**
 * ****************************************
 * author：琚涛
 * time：2019/3/19
 * description：445. 两数相加 II
 * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * 进阶:
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * ****************************************
 */
public class AddTwoNumbersII {
    public static void main(String[] args) {
        ListNode listNode1 = ListNodeHelper.generateListNode(new int[]{9, 9, 9, 9});
        ListNode listNode2 = ListNodeHelper.generateListNode(new int[]{1, 1, 1, 1});
        ListNode listNode = new AddTwoNumbersII().addTwoNumbers(listNode1, listNode2);
        ListNodeHelper.printListNode(listNode);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                stack1.push(l1.val);
                l1 = l1.next;
            }
            if (l2 != null) {
                stack2.push(l2.val);
                l2 = l2.next;
            }
        }
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        int step = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int a = 0, b = 0;
            if (!stack1.isEmpty()) {
                a = stack1.pop();
            }
            if (!stack2.isEmpty()) {
                b = stack2.pop();
            }
            int result = (a + b + step) % 10;
            step = (a + b + step) / 10;

            ListNode newNode = new ListNode(result);
            newNode.next = cur.next;
            cur.next = newNode;
        }
        if (step != 0) {
            ListNode newNode = new ListNode(step);
            newNode.next = cur.next;
            cur.next = newNode;
        }

        return head.next;
    }
}
