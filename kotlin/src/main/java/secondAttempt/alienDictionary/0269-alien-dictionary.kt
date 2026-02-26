package secondAttempt.alienDictionary

class Solution {
    fun foreignDictionary(words: Array<String>): String {
        // "hrn","hrf","er","enn","rfnn"

        // h -> e -> r -> n -> f

        val graph = buildGraph(words) ?: return ""

        val visited = HashSet<Char>()
        val path = LinkedHashSet<Char>()

        fun dfs(char: Char): Boolean {
            if (char in path) return true
            if (char in visited) return false

            val node = graph[char]!!
            visited.add(char)

            for (childNode in node.nodes) {
                if (!dfs(childNode.char)) {
                    return false
                }
            }

            path.add(char)

            return true
        }

        for (node in graph.keys) {
            if (node !in visited && !dfs(node)) {
                return ""
            }
        }

        return path.reversed().joinToString(separator = "")
    }

    private fun buildGraph(words: Array<String>): Map<Char, Node>? {
        val nodes = LinkedHashMap<Char, Node>()

        for (word in words) {
            for (c in word) {
                nodes[c] = Node(c)
            }
        }

        for (i in 1..words.lastIndex) {
            val prev = words[i - 1]
            val word = words[i]

            val (lesser, bigger) = if (word.first() != prev.first()) {
                prev.first() to word.first()
            } else {
                if (prev.startsWith(word) && word.length != prev.length) return null

                if (word.startsWith(prev)) {
                    continue

                } else {
                    var j = 1
                    while (word[j] == prev[j]) j++
                    prev[j] to word[j]
                }
            }

            val l = nodes[lesser]!!
            val b = nodes[bigger]!!

            l.nodes.add(b)
        }

        return nodes
    }

    data class Node(
        val char: Char,
        val nodes: MutableList<Node> = mutableListOf()
    ) {
        override fun toString(): String {
            return "Node($char, nodes=${nodes.map { it.char }})"
        }
    }
}
