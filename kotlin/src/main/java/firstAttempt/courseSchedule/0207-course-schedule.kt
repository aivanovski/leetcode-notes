package firstAttempt.courseSchedule

class Solution {

    fun canFinish(
        numCourses: Int,
        deps: Array<IntArray>
    ): Boolean {
        val courseToDependenciesMap = buildCourseToDependenciesMap(deps)

        val resolvedCourses = HashMap<Int, Boolean>()
        for (i in 0 until numCourses) {
            val isResolved = isResolved(i, courseToDependenciesMap, resolvedCourses, HashSet())
            if (!isResolved) {
                return false
            }
        }

        return true
    }

    private fun buildCourseToDependenciesMap(deps: Array<IntArray>): Map<Int, List<Int>> {
        val courseToDependenciesMap = HashMap<Int, MutableList<Int>>()

        for (dep in deps) {
            val course = dep[0]
            val dependency = dep[1]

            courseToDependenciesMap[course] =
                courseToDependenciesMap.getOrDefault(course, mutableListOf())
                    .apply {
                        add(dependency)
                    }
        }

        return courseToDependenciesMap
    }

    private fun isResolved(
        course: Int,
        courseToDependenciesMap: Map<Int, List<Int>>,
        resolvedCourses: HashMap<Int, Boolean>,
        visited: HashSet<Int>
    ): Boolean {
        val courseDeps = courseToDependenciesMap[course] ?: emptyList()
        val isResolved = resolvedCourses[course] ?: false
        if (isResolved) {
            return true
        }

        if (!isResolved && visited.contains(course)) {
            return false
        }

        visited.add(course)

        if (courseDeps.isEmpty()) {
            resolvedCourses[course] = true
            return true
        }

        for (dep in courseDeps) {
            val isResolved = isResolved(dep, courseToDependenciesMap, resolvedCourses, visited)
            if (!isResolved) {
                return false
            }
        }

        resolvedCourses[course] = true

        return true
    }
}