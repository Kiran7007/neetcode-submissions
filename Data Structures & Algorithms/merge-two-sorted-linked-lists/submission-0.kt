/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var node:  ListNode = ListNode(0)
        var curr: ListNode? = node
        var first = list1
        var second = list2

        while(first != null && second != null) {
            if (first.`val` < second.`val`) {
                curr?.next = first
                first = first.next
            } else {
                curr?.next = second
                second = second.next
            }
            curr = curr?.next
        }

        curr?.next = first ?: second

        return node.next
    }
}
