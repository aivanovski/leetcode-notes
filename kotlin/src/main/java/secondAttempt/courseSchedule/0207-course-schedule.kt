package secondAttempt.courseSchedule

class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        // numCourses = 2, prerequisites = [[1,0]]
        // numCourses = 2, prerequisites = [[1,0],[0,1]]

        // build a graph
        // for n in nodes
        //    if (n !in resolved) { check for cycle and return }
        val graph = buildGraph(prerequisites)

        val resolved = HashSet<Int>()
        for (node in 0 until numCourses) {
            if (node !in resolved && !markResolved(node, graph, resolved, HashSet())) {
                return false
            }
        }

        return true
    }

    private fun markResolved(
        node: Int,
        graph: Map<Int, List<Int>>,
        resolved: HashSet<Int>,
        visited: HashSet<Int>
    ): Boolean {
        // [1,0],[0,3],[0,2],[3,2],[2,5],[4,5],[5,6],[2,4]
        // 1 => 0 => 3,2
        // 3 => 2 => 5, 4
        // 4 => 5 => 6

        val isResolved = node in resolved
        if (isResolved) {
            return true
        }

        if (node in visited) {
            return false
        }

        visited.add(node)

        val deps = graph[node] ?: emptyList()
        for (dep in deps) {
            val isDepResolved = markResolved(dep, graph, resolved, visited)
            if (!isDepResolved) {
                return false
            }
        }

        resolved.add(node)

        return true
    }

    private fun buildGraph(prerequisites: Array<IntArray>): MutableMap<Int, MutableList<Int>> {
        val map = HashMap<Int, MutableList<Int>>()

        for ((course, dependency) in prerequisites) {
            map[course] = map.getOrDefault(course, mutableListOf())
                .apply {
                    add(dependency)
                }
        }

        return map
    }
}