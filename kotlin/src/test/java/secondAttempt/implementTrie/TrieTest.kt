package secondAttempt.implementTrie

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TrieTest {
    @Test
    fun implementTrie() {
        with(Trie()) {
            insert("apple")
            search("apple") shouldBe true
            search("app") shouldBe false
            startsWith("app") shouldBe true
            insert("app")
            search("app") shouldBe true
        }

        with(Trie()) {
            insert("a")
            search("a") shouldBe true
            startsWith("a") shouldBe true
        }

        with(Trie()) {
            insert("hello")
            search("hell") shouldBe false
            search("helloa") shouldBe false
        }

        with(Trie()) {
            insert("a")
            insert("ab")
            insert("abc")
            search("a") shouldBe true
            search("ab") shouldBe true
            search("abc") shouldBe true
        }
    }

}