package secondAttempt.mergeKSortedLists

import common.ListNode
import java.util.PriorityQueue

class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {

        val heap = PriorityQueue<Pair<Int, ListNode>>(
            Comparator { lhs, rhs -> lhs.first.compareTo(rhs.first) }
        )

        for (list in lists) {
            if (list != null) heap.add(list.value to list)
        }

        if (heap.isEmpty()) return null

        val head = heap.peek().second

        var curr: ListNode? = null
        var prev: ListNode? = null

        while (heap.isNotEmpty()) {
            curr = heap.poll().second

            // Add next element to the heap
            curr.next?.let { heap.add(it.value to it) }

            curr.next = null
            prev?.next = curr

            prev = curr
        }

        return head
    }

    private val ListNode.value: Int
        get() = this.`val`
}