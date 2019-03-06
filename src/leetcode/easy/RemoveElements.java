package easy;

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
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(6);
        listNode.next.next.next.next.next = new ListNode(6);
        listNode.next.next.next.next.next.next = new ListNode(6);
        listNode.next.next.next.next.next.next.next = new ListNode(6);
        ListNode listNode1 = new RemoveElements().removeElements(listNode, 6);
        System.out.println(listNode1);
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        while (head.val == val) {
            head = head.next;
            if (head == null) {
                return head;
            }
        }
        ListNode currentNode = head.next;
        ListNode lastNode = head;
        while (currentNode != null) {
            if (currentNode.val == val) {
                lastNode.next = currentNode.next;
                currentNode = currentNode.next;
                continue;
            }
            lastNode = currentNode;
            currentNode = currentNode.next;
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }
}



