package medium

/**
 * ****************************************
 * author：琚涛
 * time：2018/9/27
 * description：You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * ****************************************
 */
fun main(args: Array<String>) {
    val l1 = ListNode(9)
    l1.next=ListNode(9)
    l1.next!!.next=ListNode(9)

    val l2 = ListNode(9)
    l2.next=ListNode(9)
    l2.next!!.next=ListNode(9)

    AddTwoNumbers.addTwoNumbers(l1, l2)
}
class ListNode(var `val`: Int = 0) {
    var next: ListNode? = null
}
class AddTwoNumbers {
    companion object {
        @JvmStatic
        fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
            val l3= ListNode(0)
            var p: ListNode? =l1
            var q: ListNode? =l2
            var curr: ListNode? =l3
            var carry=0
            while (p!=null||q!=null){
                var x=0
                var y=0
                if(p!=null){
                    x=p.`val`
                    p=p.next
                }
                if(q!=null){
                    y=q.`val`
                    q=q.next
                }
                val sum:Int=x+y+carry
                carry=sum/10
                curr!!.next= ListNode(sum%10)
                curr=curr.next
            }
            if(carry>0){
                curr!!.next= ListNode(carry)
            }
            return l3.next
        }
    }
}