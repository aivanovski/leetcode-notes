package firstAttempt.removeNthNodeFromEndOfList

import common.ListNode

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
// https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if (head?.next == null) return null
        // 1 -> 2 -> 3 -> 4 -> 5
        //   -->>              *

        // Easier
        // count nodes
        // calculate position for n-th node
        // iterate and remove

        var count = 0
        var current = head

        while (current != null) {
            current = current.next
            count++
        }

        val targetIndex = count - n
        if (targetIndex == 0) {
            return head.next
        }

        current = head

        var prev: ListNode? = null
        var index = 0

        while (current != null) {
            if (index == targetIndex) {
                prev?.next = current.next
                break
            }

            prev = current
            current = current.next
            index++
        }

        return head
    }
}