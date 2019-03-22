package medium;

import medium.ListNodeHelper.ListNode;
/**
 * ****************************************
 * author：琚涛
 * time：2019/3/21
 * description：148. 排序链表
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * ****************************************
 */
public class SortList {
    public static void main(String[] args) {
        int[] arr=new int[]{6,7,2,4,5,6,1,3,14,57,23,12,11,111,222,3,34,43,35,23,1234};
        sortArr(arr);
        System.out.println(arr);
    }
    public ListNode sortList(ListNode head) {
        return head==null?null:mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        if(head.next==null){
            return head;
        }
        ListNode p=head;
        ListNode q=head;
        ListNode pre=null;
        while (q!=null&&q.next!=null){
            pre=p;
            p=p.next;
            q=q.next.next;
        }
        pre.next=null;
        ListNode l=mergeSort(head);
        ListNode r=mergeSort(p);
        return merge(l,r);
    }

    private ListNode merge(ListNode l, ListNode r) {
        ListNode dummy=new ListNode(-1);
        ListNode cur=dummy;
        while (l!=null&&r!=null){
            if(l.val<r.val){
                cur.next=l;
                cur=cur.next;
                l=l.next;
            }else {
                cur.next=r;
                cur=cur.next;
                r=r.next;
            }
        }
        if(l!=null){
            cur.next=l;
        }
        if(r!=null){
            cur.next=r;
        }
        return dummy.next;
    }

    public static void sortArr(int[] arr){
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int l, int r) {
        if(l>=r){
            return;
        }
        int mid=(l+r)/2;
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        if(arr[mid]>arr[mid+1]){
            merge(arr,l,mid,r);
        }
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int[] aux=new int[r-l+1];
        for (int i = l; i <=r; i++) {
            aux[i-l]=arr[i];
        }
        int i=l;
        int j=mid+1;
        for (int k = l; k <=r; k++) {
            if(i>mid){
                arr[k]=aux[j-l];
                j++;
            }else if(j>r){
                arr[k]=aux[i-l];
                i++;
            }else if(aux[i-l]<aux[j-l]){
                arr[k]=aux[i-l];
                i++;
            }else{
                arr[k]=aux[j-l];
                j++;
            }
        }
    }
}
