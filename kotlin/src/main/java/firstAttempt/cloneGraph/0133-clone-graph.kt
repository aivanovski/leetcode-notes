package firstAttempt.cloneGraph

import common.Node

// https://leetcode.com/problems/clone-graph/description/
class Solution {
    fun cloneGraph(root: Node?): Node? {
        if (root == null) return null

        val newNodeMap = HashMap<Int, Node>()

        fun cloneDfs(
            node: Node
        ): Node {
            val newNode = Node(node.value)

            newNodeMap[node.value] = newNode

            for (neighbour in node.neighbors) {
                if (neighbour == null) continue

                val clonedNeighbour = if (!newNodeMap.containsKey(neighbour.value)) {
                    cloneDfs(neighbour)
                } else {
                    newNodeMap[neighbour.value] as Node
                }

                newNode.neighbors.add(clonedNeighbour)
            }

            return newNode
        }

        return cloneDfs(root)
    }


    val Node.value: Int
        get() = this.`val`
}