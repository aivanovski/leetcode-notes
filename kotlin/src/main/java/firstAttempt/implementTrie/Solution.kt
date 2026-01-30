package firstAttempt.implementTrie

class Trie {

    private val root = Node(char = null)

    fun insert(word: String) {
        val nodes = findNodes(word)

        var parent = nodes.lastOrNull() ?: root

        if (nodes.size == word.length) {
            nodes.last().isWord = true
            return
        }

        val startIdx = nodes.size
        for (idx in startIdx until word.length) {
            val char = word[idx]
            val newNode = Node(
                char = char,
                isWord = idx == word.lastIndex
            )
            parent.nodes.add(newNode)
            parent = newNode
        }
    }

    fun search(word: String): Boolean {
        val nodes = findNodes(word)
        return nodes.size == word.length && nodes.lastOrNull()?.isWord == true
    }

    fun startsWith(prefix: String): Boolean {
        val nodes = findNodes(prefix)
        return nodes.size == prefix.length
    }

    private fun findNodes(word: String): List<Node> {
        val matchedNodes = mutableListOf<Node>()

        fun dfs(node: Node, wordIdx: Int) {
            for (childNode in node.nodes) {
                if (childNode.char == word[wordIdx]) {
                    matchedNodes.add(childNode)
                    if (wordIdx == word.lastIndex) {
                        return
                    }

                    dfs(childNode, wordIdx + 1)
                }
            }
        }

        dfs(root, wordIdx = 0)

        return matchedNodes
    }

    data class Node(
        val char: Char?,
        var isWord: Boolean = false,
        val nodes: MutableList<Node> = mutableListOf()
    )
}
