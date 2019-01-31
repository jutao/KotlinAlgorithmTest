package medium;

/**
 * ****************************************
 * author：琚涛
 * time：2019/1/31
 * description：
 * ****************************************
 */
public class DetectCycle {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=head.next;
        System.out.println(detectCycle(head).val);
    }
    public static ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null && slow != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode temp=head;
                while(slow!=null){
                    if(slow==temp){
                        return slow;
                    }
                    slow=slow.next;
                    temp=temp.next;
                }
            }
        }
        return null;
    }
}
