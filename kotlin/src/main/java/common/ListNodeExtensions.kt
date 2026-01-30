package common

import java.util.*

fun ListNode?.collect(): List<Int> {
    if (this == null) {
        return emptyList()
    }

    var current = this
    val result = mutableListOf<Int>()

    while (current != null) {
        result.add(current.`val`)
        current = current.next
    }

    return result
}

fun List<Int>.toNodeList(): ListNode? {
    if (isEmpty()) {
        return null
    }

    val root = ListNode(first())
    var current = root

    val items = LinkedList(subList(1, size))
    while (items.isNotEmpty()) {
        val nextNode = ListNode(items.pop())
        current.next = nextNode
        current = nextNode
    }

    return root
}

fun ListNode?.findLastNode(): ListNode? {
    var current = this

    while (current?.next != null) {
        current = current.next
    }

    return current
}