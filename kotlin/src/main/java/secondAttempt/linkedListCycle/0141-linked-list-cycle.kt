package secondAttempt.linkedListCycle

import common.ListNode

class Solution {
    fun hasCycle(head: ListNode?): Boolean {
        var slow = head
        var fast = head?.next?.next

        while (fast != null) {
            if (fast === slow) return true

            slow = slow?.next
            fast = fast.next?.next
        }

        return false
    }
}