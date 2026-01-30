package firstAttempt.linkedListCycle

import common.ListNode

class Solution {
    fun hasCycle(head: ListNode?): Boolean {
        var slow = head
        var fast = head?.next?.next

        while (slow != null) {
            if (slow === fast) return true

            slow = slow.next
            fast = fast?.next?.next
        }

        return false
    }
}