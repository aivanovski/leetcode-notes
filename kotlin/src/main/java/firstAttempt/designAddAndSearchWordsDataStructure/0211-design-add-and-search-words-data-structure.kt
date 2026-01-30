package firstAttempt.designAddAndSearchWordsDataStructure

import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class WordDictionary {

    private var root = Node(Optional.empty())

    fun addWord(word: String) {
        if (word.isEmpty()) return

        val nodes = findMatch(word)
        if (nodes.size == word.length) {
            // already added
            val lastNode = nodes.last().first()
            if (!lastNode.isEnd) {
                lastNode.isEnd = true
            }

            return
        }

        var parent = nodes.lastOrNull()?.firstOrNull() ?: root
        for (wordIdx in nodes.size until word.length) {
            val newNode = Node(
                char = Optional.of(word[wordIdx]),
                isEnd = (wordIdx == word.lastIndex)
            )
            parent.nodes.add(newNode)
            parent = newNode
        }
    }

    fun search(word: String): Boolean {
        if (word.isEmpty()) return false

        val nodes = findMatch(word)
        return nodes.size == word.length
            && nodes.last().any { n -> n.isEnd }
    }

    private fun findMatch(word: String): List<List<Node>> {
        val nodes = mutableListOf<List<Node>>()

        var wordIdx = 0
        var searchNodes = listOf(root)

        while (wordIdx < word.length) {
            val matchedNode = mutableListOf<Node>()
            for (n in searchNodes) {
                matchedNode.addAll(
                    n.nodes.filter { node ->
                        node.char.getOrNull() == word[wordIdx] || word[wordIdx] == '.'
                    }
                )
            }

            if (matchedNode.isNotEmpty()) {
                nodes.add(matchedNode)
                searchNodes = matchedNode
                wordIdx++
            } else {
                break
            }
        }

        return nodes
    }

    data class Node(
        val char: Optional<Char>,
        var isEnd: Boolean = false,
        val nodes: MutableList<Node> = mutableListOf()
    )
}