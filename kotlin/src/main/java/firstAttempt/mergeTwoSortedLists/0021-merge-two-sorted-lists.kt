package firstAttempt.mergeTwoSortedLists

import common.ListNode

// https://leetcode.com/problems/merge-two-sorted-lists/description/
class Solution {
    fun mergeTwoLists(left: ListNode?, right: ListNode?): ListNode? {
        var currentLeft = left
        var currentRight = right

        var current: ListNode? = null
        var prev: ListNode? = null
        var mergedHead: ListNode? = null

        while (currentLeft != null || currentRight != null) {
            val valueLeft = currentLeft?.value
            val valueRight = currentRight?.value

            if ((valueLeft == null && valueRight != null)
                || (valueLeft != null && valueRight != null && valueLeft > valueRight)
            ) {
                current = currentRight
                currentRight = currentRight.next
            } else {
                current = currentLeft
                currentLeft = currentLeft?.next
            }

            if (mergedHead == null) {
                mergedHead = current
            }

            prev?.next = current
            current?.next = null
            prev = current
        }

        return mergedHead
    }

    val ListNode.value: Int
        get() = this.`val`
}