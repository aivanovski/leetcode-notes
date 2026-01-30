package firstAttempt.reorderList

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
// https://leetcode.com/problems/reorder-list/description/
class Solution {

    fun reorderList(head: ListNode?) {
        if (head == null) return
        if (head.next?.next == null) return

        // split into 2 lists
        // reverse second
        // zip 2 lists
        val (left, right) = split(head)
        val reversedRight = reverse(right)
        zip(left, reversedRight)
    }

    fun zip(leftHead: ListNode?, rightHead: ListNode?) {
        var left = leftHead
        var right = rightHead
        var nextLeft = left?.next
        var nextRight = right?.next


        // 1 -> 2 -> 3
        // 5 -> 4

        // 1 -> 5

        while (true) {

            if (right != null) {
                left?.next = right
                left?.next?.next = nextLeft

//                right = right.next

                left = nextLeft
                right = nextRight
            } else {
                break
            }


            nextLeft = nextLeft?.next
            nextRight = nextRight?.next
        }

    }

    fun reverse(head: ListNode?): ListNode? {
        // 1 -> 2 -> 3
        // *
        // 1 <- 2 <- 3

        var current: ListNode? = head
        var next: ListNode? = head?.next
        var prev: ListNode? = null
        var newHead: ListNode? = null

        while (current != null) {
            current.next = prev

            if (next == null) {
                newHead = current
            }

            prev = current
            current = next
            next = current?.next
        }

        return newHead
    }

    private fun split(head: ListNode): Pair<ListNode?, ListNode?> {
        var fast: ListNode? = head.next
        var slow: ListNode? = head

        // 1 -> 2 -> 3 -> 4
        // ^    ^
        //      ^         ^

        // 1 -> 2 -> 3 -> 4 -> 5
        // *    *
        //      *         *

        // 1 -> 2 -> 3
        // *    *

        while (fast != null) {
            if (fast.next == null) {
                val left = head
                val right = slow?.next

                // cut the list
                slow?.next = null

                return left to right

            } else if (fast.next?.next == null) {
                val left = head
                val right = slow?.next?.next

                // cut the list
                slow?.next?.next = null

                return left to right
            }

            slow = slow?.next
            fast = fast.next?.next
        }

        return null to null
    }

    val ListNode.value
        get() = this.`val`
}