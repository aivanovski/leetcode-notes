package firstAttempt.implementTrie

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class TrieTest {
    @Test
    fun implementTrie() {
        Trie().apply {
            insert("apple")
            search("apple") shouldBe true
            search("app") shouldBe false
            startsWith("app") shouldBe true
            insert("app")
            search("app") shouldBe true
        }
        /*
        Input
["Trie","insert","search","search","search","startsWith","startsWith","startsWith"]
[[],["hello"],["hell"],["helloa"],["hello"],["hell"],["helloa"],["hello"]]

Output
[null,null,false,true,true,true,true,true]

Expected
[null,null,false,false,true,true,false,true]
         */
    }

}