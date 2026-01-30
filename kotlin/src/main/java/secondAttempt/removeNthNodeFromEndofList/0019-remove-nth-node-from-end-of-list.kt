package secondAttempt.removeNthNodeFromEndofList

import common.ListNode

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var curr = head

        var nodeCount = 0
        while (curr != null) {
            curr = curr.next
            nodeCount++
        }

        // 1 2 3 4 5
        // 5 - 2 = 3
        val targetNodeIndex = nodeCount - n
        if (targetNodeIndex == 0) return head?.next

        var index = 0
        var prev: ListNode? = null
        curr = head
        while (curr != null) {
            if (index == targetNodeIndex) {
                prev?.next = curr.next
                return head
            }

            prev = curr
            curr = curr.next
            index++
        }

        return null
    }
}