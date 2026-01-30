package common

import java.util.LinkedList

fun List<List<Int>>.toNodeGraph(): Node? {
    // [[2,4],[1,3],[2,4],[1,3]]
    val nodeCount = this.size
    val nodeMap = HashMap<Int, Node>()

    for (i in 1..nodeCount) {
        nodeMap[i] = Node(`val` = i)
    }

    for ((nodeIdx, neighbours) in this.withIndex()) {
        val node = nodeMap[nodeIdx + 1]!!

        for (neighbour in neighbours) {
            val neighbourNode = nodeMap[neighbour]!!

            node.neighbors.add(neighbourNode)
        }
    }

    return if (this.isNotEmpty()) nodeMap[1]!! else null
}

fun Node?.collect(): List<List<Int>> {
    if (this == null) return emptyList()

    val root = this
    val visited = HashSet<Int>()

    val nextNodes = LinkedList<Node>()
        .apply {
            add(root)
        }

    val nodeToNeighboursMap = HashMap<Int, MutableList<Int>>()

    while (nextNodes.isNotEmpty()) {
        val nextNode = nextNodes.removeFirst()

        if (nextNode.`val` in visited) {
            continue
        } else {
            visited.add(nextNode.`val`)
        }

        val nn = nodeToNeighboursMap.get(nextNode.`val`) ?: mutableListOf()
        nodeToNeighboursMap[nextNode.`val`] = nn

        for (neighbour in nextNode.neighbors) {
            if (neighbour == null) continue

            if (neighbour.`val` !in visited) {
                nextNodes.add(neighbour)
            }

            nn.add(neighbour.`val`)
        }
    }

    return nodeToNeighboursMap.entries
        .sortedBy { (node, _) -> node }
        .map { (_, neighbours) -> neighbours.toList() }
}

fun Node.formatToString(): String {
    return this.collect().formatAsGraph()
}

fun List<List<Int>>.formatAsGraph(): String {
    return this.joinToString(
        separator = "],[",
        prefix = "[[",
        postfix = "]]",
        transform = { neighbours -> neighbours.joinToString(",") }
    )
}