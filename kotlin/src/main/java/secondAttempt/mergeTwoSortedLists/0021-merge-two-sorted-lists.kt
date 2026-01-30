package secondAttempt.mergeTwoSortedLists

import common.ListNode

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 == null && list2 == null) return null

        var lhs = list1
        var rhs = list2

        var head: ListNode? = null
        var prev: ListNode? = null
        var current: ListNode? = null

        while (lhs != null || rhs != null) {
            val lhsValue = lhs?.value ?: 0
            val rhsValue = rhs?.value ?: 0

            if ((lhsValue <= rhsValue && lhs != null)|| rhs == null) {
                current = lhs
                lhs = lhs?.next
            } else {
                current = rhs
                rhs = rhs.next
            }

            current?.next = null
            prev?.next = current
            prev = current
            if (head == null) head = current
        }

        return head
    }

    private val ListNode.value: Int
        get() = this.`val`
}