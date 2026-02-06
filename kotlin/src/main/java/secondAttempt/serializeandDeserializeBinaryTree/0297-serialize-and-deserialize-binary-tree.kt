package secondAttempt.serializeandDeserializeBinaryTree

import common.TreeNode

class Codec {
    fun serialize(root: TreeNode?): String {
        if (root == null) return ""

        val sb = StringBuilder()

        fun dfs(node: TreeNode?) {
            if (sb.isNotEmpty()) sb.append(",")

            if (node == null) {
                sb.append("N")
                return
            }

            sb.append(node.value)
            dfs(node.left)
            dfs(node.right)
        }

        dfs(root)

        return sb.toString()
    }

    fun deserialize(data: String): TreeNode? {
        if (data.isEmpty()) return null

        val values = data.split(",")
        var i = 0

        fun dfs(): TreeNode? {
            val value = values[i++]

            if (value == "N") {
                return null
            }

            val node = TreeNode(value.toInt())

            node.left = dfs()
            node.right = dfs()

            return node
        }

        return dfs()
    }

    private val TreeNode.value: Int
        get() = this.`val`
}