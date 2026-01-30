package firstAttempt.designAddAndSearchWordsDataStructure

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class WordDictionaryTest {

    @Test
    fun addWordAndSearch() {
        WordDictionary().apply {
            addWord("bad")
            addWord("dad")
            addWord("mad")
            search("pad") shouldBe false
            search("bad") shouldBe true
            search(".ad") shouldBe true
            search("b..") shouldBe true
        }

        WordDictionary().apply {
            //["WordDictionary",addWord","addWord","addWord","addWord",
            // "search","search",
            // "addWord"
            //         ,"search","search","search","search","search","search"]

            //[[],["at"],["and"],["an"],["add"],
            // ["a"],[".at"],
            // ["bat"],
            // [".at"],["an."],["a.d."],["b."],["a.d"],["."]]

            addWord("at")
            addWord("and")
            addWord("an")
            addWord("add")

            search("a") shouldBe false
            search(".at") shouldBe false

            addWord("bat")


        }
    }
}