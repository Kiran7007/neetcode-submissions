/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reorderList(head: ListNode?): Unit {
        if(head?.next == null) return

        var slow = head
        var fast = head?.next

        while(fast?.next != null) {
            slow = slow?.next
            fast = fast?.next?.next
        }

        val mid = slow?.next
        slow?.next = null
        var prev: ListNode? = null
        var curr = mid

        while(curr != null) {
            val temp =  curr?.next
            curr?.next = prev
            prev = curr
            curr = temp
        }

        var first = head
        var second = prev

        while(first != null && second != null) {
            val temp1 = first?.next
            val temp2 = second?.next

            first?.next = second
            second?.next = temp1
            first = temp1
            second = temp2
        }
    }
}
