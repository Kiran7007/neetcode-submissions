/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        return divide(lists, 0, lists.lastIndex)
    }

    private fun divide(lists: Array<ListNode?>, left: Int, right: Int): ListNode? {
        if(left > right)  return null
        if(left == right) return lists[left]

        val mid = left + (right - left) / 2
        val first = divide(lists, left, mid)
        val second = divide(lists, mid+1, right)

        return conquer(first, second)
    }

    private fun conquer(left: ListNode?, right: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var curr: ListNode? = dummy
        var first = left
        var second = right

        while(first != null && second != null) {
            if(first.`val` <= second.`val`) {
                curr?.next = first
                first = first?.next
            } else {
                curr?.next = second
                second = second?.next
            }
            curr = curr?.next!!
        }

        curr?.next = first ?: second
        return dummy?.next
    }
}
