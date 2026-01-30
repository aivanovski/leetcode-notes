package common

import java.util.LinkedList

fun List<Int?>.toTreeNodes(): TreeNode? {
    if (isEmpty()) {
        return null
    }

    val root = TreeNode(first() ?: throw IllegalStateException())
    val nextNodes = LinkedList<TreeNode>()
        .apply {
            add(root)
        }

    val items = LinkedList(subList(1, size))
    while (items.isNotEmpty()) {
        val leftValue = items.pop()
        val rightValue = if (items.isNotEmpty()) {
            items.pop()
        } else {
            null
        }

        val leftNode = if (leftValue != null) {
            TreeNode(leftValue)
        } else {
            null
        }
        val rightNode = if (rightValue != null) {
            TreeNode(rightValue)
        } else {
            null
        }

        val currentNode = if (nextNodes.isNotEmpty()) {
            nextNodes.pop()
        } else {
            break
        }
        currentNode.left = leftNode
        currentNode.right = rightNode

        if (leftNode != null) {
            nextNodes.add(leftNode)
        }
        if (rightNode != null) {
            nextNodes.add(rightNode)
        }
    }

    return root
}

fun TreeNode?.collect(): List<Int?> {
    if (this == null) {
        return emptyList()
    }

    val result = mutableListOf<Int?>()
    val nextItems = LinkedList<TreeNode>()
    nextItems.add(this)

    while (nextItems.isNotEmpty()) {
        val current = nextItems.pop()

        current.left?.let {
            nextItems.add(it)
        }

        current.right?.let {
            nextItems.add(it)
        }

        result.add(current.`val`)
    }

    return result
}

fun TreeNode?.collectTreeStructure(): List<Int?> {
    if (this == null) {
        return emptyList()
    }

    val root = this

    val result = mutableListOf<Int?>()
    val queue = LinkedList<TreeNode?>()
        .apply {
            add(root)
        }

    while (queue.isNotEmpty()) {
        val nodeCount = queue.size

        var hasNextLevel = false
        for (idx in 0 until nodeCount) {
            val node = queue.removeFirst()

            result.add(node?.`val`)

            queue.add(node?.left)
            queue.add(node?.right)

            if (node?.left != null || node?.right != null) {
                hasNextLevel = true
            }
        }

        if (!hasNextLevel) {
            break
        }
    }

    val lastValueIdx = result.indexOfLast { value -> value != null }
    return if (lastValueIdx != -1 && lastValueIdx != result.lastIndex) {
        result.subList(0, lastValueIdx + 1)
    } else {
        result
    }
}

fun TreeNode?.collectNonNull(): List<Int> {
    if (this == null) {
        return emptyList()
    }

    val result = mutableListOf<Int>()
    val nextItems = LinkedList<TreeNode>()
    nextItems.add(this)

    while (nextItems.isNotEmpty()) {
        val current = nextItems.pop()

        current.left?.let {
            nextItems.add(it)
        }

        current.right?.let {
            nextItems.add(it)
        }

        result.add(current.`val`)
    }

    return result
}

fun TreeNode.findNode(value: Int): TreeNode {
    val nodes = LinkedList<TreeNode>()
    nodes.add(this)

    while (nodes.isNotEmpty()) {
        val current = nodes.pop()

        current.left?.let {
            nodes.add(it)
        }

        current.right?.let {
            nodes.add(it)
        }

        if (value == current.`val`) {
            return current
        }
    }

    throw IllegalArgumentException()
}