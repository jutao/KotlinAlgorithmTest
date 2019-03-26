package easy;

/**
 * ****************************************
 * author：琚涛
 * time：2019/3/22
 * description：707. 设计链表
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：
 * val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用
 * 双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点
 * 都是 0-index 的。
 * ****************************************
 */
public class MyLinkedList {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
       myLinkedList.addAtHead(5);
       myLinkedList.addAtHead(2);
       myLinkedList.deleteAtIndex(1);
    }
    ListNode dummyHead;
    ListNode dummyTail;
    int length=0;

    public MyLinkedList() {
        dummyHead=new ListNode(-1);
        dummyTail=new ListNode(-1);
        dummyHead.next=dummyTail;
        dummyTail.prev=dummyHead;
    }

    /**
     * 获取链表中第 index 个节点的值。如果索引无效，则返回-1
     * @param index
     * @return
     */
    public int get(int index) {
        if(length<=index){
            return -1;
        }
        ListNode cur=getIndexNode(index);

        return cur.val;
    }

    private ListNode getIndexNode(int index){
        ListNode cur=dummyHead;
        if(index==-1){
            return cur;
        }
        if(length-index<index){
            //反向查找
            cur=dummyTail;
            for (int i = length-1; i >=index ; i--) {
                cur=cur.prev;
            }
        }else {
            //正向查找
            for (int i = 0; i <=index; i++) {
                cur=cur.next;
            }
        }
        return cur;
    }


    /**
     * 在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
     * @param val
     */
    public void addAtHead(int val) {
        ListNode head=dummyHead.next;
        dummyHead.next=new ListNode(val);
        dummyHead.next.prev=dummyHead;
        dummyHead.next.next=head;
        head.prev=dummyHead.next;
        length++;
    }

    /**
     * 将值为 val 的节点追加到链表的最后一个元素。
     * @param val
     */
    public void addAtTail(int val) {
        ListNode tail=dummyTail.prev;
        dummyTail.prev=new ListNode(val);
        dummyTail.prev.next=dummyTail;
        dummyTail.prev.prev=tail;
        tail.next=dummyTail.prev;
        length++;
    }

    /**
     * 在链表中的第 index 个节点之前添加值为 val  的节点。如果 index
     * 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。
     * @param index
     * @param val
     */
    public void addAtIndex(int index, int val) {
        if (index>length){
            return;
        }
        if(index==length){
            ListNode indexNode = dummyTail;
            ListNode prev=indexNode.prev;
            indexNode.prev=new ListNode(val);
            indexNode.prev.next=indexNode;
            indexNode.prev.prev=prev;
            prev.next=indexNode.prev;

            length++;
            return;
        }
        ListNode indexNode = getIndexNode(index - 1);
        ListNode next=indexNode.next;
        indexNode.next=new ListNode(val);
        indexNode.next.next=next;
        indexNode.next.prev=indexNode;
        indexNode.next.next.prev=indexNode.next;
        length++;
    }

    /**
     * 如果索引 index 有效，则删除链表中的第 index 个节点。
     * @param index
     */
    public void deleteAtIndex(int index) {
        if ((index>=length)){
            return;
        }
        ListNode indexNode = getIndexNode(index - 1);
        ListNode next=indexNode.next.next;

        indexNode.next=next;
        next.prev=indexNode;
        length--;

    }

    private class ListNode{
        int val;
        ListNode next;
        ListNode prev;

        ListNode(int val) {
            this.val = val;
        }
    }
}
