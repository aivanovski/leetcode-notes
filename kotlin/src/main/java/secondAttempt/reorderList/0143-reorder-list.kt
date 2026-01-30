package secondAttempt.reorderList

import common.ListNode
import java.util.LinkedList

class Solution {
    fun reorderList(root: ListNode?) {
        // put all nodes into LinkedList
        // remove from head and tail
        if (root == null) return

        val list = LinkedList<ListNode>()

        var curr: ListNode? = root
        while (curr != null) {
            list.add(curr)
            curr = curr.next
        }

        var prevHead: ListNode? = null
        var prevTail: ListNode? = null

        while (list.isNotEmpty()) {
            val head = list.removeFirst()
            val tail = if (list.isNotEmpty()) list.removeLast() else null

            head.next = tail
            tail?.next = null

            prevTail?.next = head

            prevHead = head
            prevTail = tail
        }
    }
}