package firstAttempt.wordSearch

class Solution {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        // ABCE
        // SFCS
        // ADEE
        //
        // ABCCED
        if (board.isEmpty()) return false

        val rows = board.size
        val cols = board.first().size

        val rowsRange = 0 until rows
        val colsRange = 0 until cols

        val path = mutableListOf<Pair<Int, Int>>()
        val visited = HashSet<Pair<Int, Int>>()

        fun dfs(
            row: Int,
            col: Int,
            prev: String
        ): Boolean {
            if (row !in rowsRange
                || col !in colsRange
                || (row to col) in visited
            ) return false

            val currChar = board[row][col]
            if (currChar != word.getOrNull(prev.length)) return false

            val curr = prev + currChar
            path.add(row to col)
            visited.add(row to col)

            for ((dr, dc) in DIRECTIONS) {
                val nr = row + dr
                val nc = col + dc

                if (dfs(nr, nc, curr)) {
                    return true
                }
            }

            val toRemove = path.removeLast()
            visited.remove(toRemove)

            return curr.length == word.length
        }

        for (r in 0 until rows) {
            for (c in 0 until cols) {
                if (board[r][c] == word.first() && dfs(r, c, "")) {
                    return true
                }
            }
        }

        return false
    }

    companion object {
        private val DIRECTIONS = listOf(
            -1 to 0,
            1 to 0,
            0 to -1,
            0 to 1
        )
    }
}