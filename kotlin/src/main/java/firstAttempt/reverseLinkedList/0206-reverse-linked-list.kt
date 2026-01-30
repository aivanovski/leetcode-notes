package firstAttempt.reverseLinkedList

import common.ListNode

// https://leetcode.com/problems/reverse-linked-list/description/
class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        if (head == null) return null

        var curr: ListNode? = head
        var prev: ListNode? = null
        var last: ListNode? = null

        while (curr != null) {
            val next = curr.next
            if (next == null) last = curr

            curr.next = prev

            prev = curr
            curr = next
        }

        return last
    }
}