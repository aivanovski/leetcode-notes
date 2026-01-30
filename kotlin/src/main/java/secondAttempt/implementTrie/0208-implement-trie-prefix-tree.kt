package secondAttempt.implementTrie

class Trie {

    private val root = Node(char = null)

    fun insert(word: String) {
        val (lastMatchWordIndex, lastMatchNode) = findNode(root, word, nextCharIndex = 0)

        if (lastMatchNode.isEnd && lastMatchWordIndex == word.lastIndex) {
            // word exists
            return
        }

        if (lastMatchWordIndex == word.lastIndex && !lastMatchNode.isEnd && !lastMatchNode.isRoot()) {
            lastMatchNode.isEnd = true
            return
        }

        val startIndex = if (lastMatchWordIndex != -1) lastMatchWordIndex + 1 else 0
        var parent = lastMatchNode
        for (i in startIndex until word.length) {
            val newNode = Node(
                char = word[i],
                isEnd = i == word.lastIndex
            )

            parent.nodes.add(newNode)
            parent = newNode
        }
    }

    fun search(word: String): Boolean {
        val (index, node) = findNode(root, word)
        return index == word.lastIndex && node.isEnd
    }

    fun startsWith(prefix: String): Boolean {
        val (index, node) = findNode(root, prefix)
        return !node.isRoot() && index == prefix.lastIndex
    }

    private fun findNode(node: Node, word: String, nextCharIndex: Int = 0): Pair<Int, Node> {
        val letter = word[nextCharIndex]

        for (child in node.nodes) {
            if (child.char == letter) {
                return if (nextCharIndex == word.lastIndex) {
                    nextCharIndex to child
                } else {
                    findNode(child, word, nextCharIndex + 1)
                }
            }
        }

        return if (node.isRoot()) -1 to node else nextCharIndex - 1 to node
    }

    private fun Node.isRoot(): Boolean {
        return this.char == null
    }

    private data class Node(
        val char: Char?,
        var isEnd: Boolean = false,
        val nodes: MutableList<Node> = mutableListOf()
    )
}