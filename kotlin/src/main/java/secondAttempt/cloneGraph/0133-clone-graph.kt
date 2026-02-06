package secondAttempt.cloneGraph

import common.Node

class Solution {
    fun cloneGraph(root: Node?): Node? {
        if (root == null) return null

        val numToCloneMap = HashMap<Int, Node>()

        // 1 -> 2,4
        // 2 -> 1,3
        // 3 -> 2,4
        // 4 -> 1,3

        fun clone(node: Node): Node {
            val clone = numToCloneMap[node.value] ?: Node(node.value)

            numToCloneMap[node.value] = clone

            for (neighbour in node.neighbors) {
                if (neighbour == null) continue

                if (neighbour.value in numToCloneMap) {
                    clone.neighbors.add(numToCloneMap[neighbour.value])
                } else {
                    clone.neighbors.add(clone(neighbour))
                }
            }

            return clone
        }

        return clone(root)
    }

    private val Node.value: Int
        get() = this.`val`
}