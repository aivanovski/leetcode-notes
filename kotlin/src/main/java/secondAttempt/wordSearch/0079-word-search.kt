package secondAttempt.wordSearch

class Solution {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        // for (r in rows)
        //   for (c in cols)
        //       if (board[r][c] == word.first() && check_dfs()) return true

        val rowRange = 0 until board.size
        val colRange = 0 until (board.firstOrNull()?.size ?: 0)

        val path = HashSet<Pair<Int, Int>>()

        fun check(
            row: Int,
            col: Int,
        ): Boolean {
            if (row !in rowRange || col !in colRange) return false
            if (path.size >= word.length) return false
            if (path.contains(row to col)) return false
            if (board[row][col] != word[path.size]) return false

            if (path.size == word.length - 1) return true

            path.add(row to col)

            val isFound = check(row - 1, col)
                || check(row + 1, col)
                || check(row, col - 1)
                || check(row, col + 1)

            path.remove(row to col)

            return isFound
        }

        for (row in rowRange) {
            for (col in colRange) {
                if (board[row][col] == word.first() && check(row, col)) {
                    return true
                }
            }
        }

        return false
    }
}