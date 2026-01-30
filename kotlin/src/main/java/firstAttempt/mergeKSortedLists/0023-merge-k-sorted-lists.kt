package firstAttempt.mergeKSortedLists

import common.ListNode
import java.util.PriorityQueue

class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val heap = PriorityQueue<Pair<Int, Int>>(compareBy { it.first })

        for ((index, node) in lists.withIndex()) {
            if (node != null) {
                heap.add(node.value to index)
            }
        }

        var root: ListNode? = null
        var curr: ListNode? = null

        while (heap.isNotEmpty()) {
            val (_, listIndex) = heap.poll()

            val node = lists[listIndex]

            curr?.next = node
            curr = node

            val listNextNode = node?.next
            lists[listIndex] = listNextNode

            if (listNextNode != null) {
                heap.add(listNextNode.value to listIndex)
            }

            if (root == null) {
                root = node
            }
        }

        curr?.next = null

        return root
    }

    private val ListNode.value: Int
        get() = this.`val`
}