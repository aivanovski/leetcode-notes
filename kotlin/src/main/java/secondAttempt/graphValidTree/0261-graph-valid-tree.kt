package secondAttempt.graphValidTree

class Solution {
    fun validTree(n: Int, edges: Array<IntArray>): Boolean {
        // build 2-directional graph
        // check for cycle
        // check all nodes are connected

        val graph = buildGraph(edges)
        val visited = HashSet<Int>()

        val hasCycle = hasCycle(graph, visited)

        println("graph=$graph, hasCycle=$hasCycle, visited=$visited")

        return !hasCycle && visited.size == n
    }

    private fun hasCycle(
        graph: Map<Int, List<Int>>,
        visited: HashSet<Int>
    ): Boolean {
        // [[0,1],[1,3],[3,0],[2,4]]
        // 0 -> 1 -> 3
        // 0   <-    3
        //

        val root = 0
        val visitedFrom = HashMap<Int, Int?>()

        fun hasCycleDfs(node: Int, from: Int?): Boolean {
            val nextNodes = graph[node] ?: emptyList()

            visited.add(node)

            val prevFrom = visitedFrom[node]
            if (visitedFrom.contains(node) && prevFrom != from) return true

            visitedFrom[node] = from

            for (nextNode in nextNodes) {
                if (nextNode != from && hasCycleDfs(nextNode, node)) return true
            }

            return false
        }

        return hasCycleDfs(root, null)
    }

    private fun buildGraph(edges: Array<IntArray>): Map<Int, List<Int>> {
        val graph = HashMap<Int, MutableList<Int>>()

        for (edge in edges) {
            val (from, to) = edge
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

