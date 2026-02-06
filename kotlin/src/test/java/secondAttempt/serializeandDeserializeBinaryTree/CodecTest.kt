package secondAttempt.serializeandDeserializeBinaryTree

import common.collectTreeStructure
import common.toTreeNodes
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class CodecTest {
    @Test
    fun serializeAndDeserialize() {
        listOf(
            listOf(1, 2, 3, null, null, 4, 5),
        ).forEach { input ->
            with(Codec()) {
                val tree = input.toTreeNodes()
                deserialize(serialize(tree))?.collectTreeStructure() shouldBe tree?.collectTreeStructure()
            }
        }
    }
}