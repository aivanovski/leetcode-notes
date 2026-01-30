package secondAttempt.numberofConnectedComponentsinanUndirectedGrap

import java.util.LinkedList

class Solution {
    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        // build bi-directional graph
        // for n in nodes
        //     if (n not visited) mark with dfs and count++
        val graph = buildGraph(edges)

        val visited = HashSet<Int>()
        var count = 0
        for (node in 0 until n) {
            if (node !in visited) {
                visitNodes(node, graph, visited)
                count++
            }
        }

        return count
    }

    private fun visitNodes(
        startNode: Int,
        graph: Map<Int, List<Int>>,
        visited: MutableSet<Int>
    ) {
        val queue = LinkedList<Int>()
            .apply {
                add(startNode)
            }

        while (queue.isNotEmpty()) {
            val node = queue.removeFirst()

            if (node in visited) continue

            visited.add(node)

            val connectedNodes = graph[node] ?: emptyList()
            for (connectedNode in connectedNodes) {
                if (connectedNode !in visited) {
                    queue.add(connectedNode)
                }
            }
        }
    }

    private fun buildGraph(edges: Array<IntArray>): Map<Int, List<Int>> {
        val graph = HashMap<Int, MutableList<Int>>()

        for (edge in edges) {
            val from = edge[0]
            val to = edge[1]

            graph[from] = graph.getOrDefault(from, mutableListOf())
                .apply {
                    add(to)
                }

            graph[to] = graph.getOrDefault(to, mutableListOf())
                .apply {
                    add(from)
                }
        }

        return graph
    }
}

