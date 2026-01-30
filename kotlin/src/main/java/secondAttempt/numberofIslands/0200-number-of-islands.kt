package secondAttempt.numberofIslands

class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        val rowsRange = 0 until grid.size
        val colsRange = 0 until (grid.firstOrNull()?.size ?: 0)

        fun removeIsland(
            row: Int,
            col: Int
        ) {
            if (row !in rowsRange || col !in colsRange) return
            if (grid[row][col] == '0') return

            grid[row][col] = '0'

            removeIsland(row - 1, col)
            removeIsland(row + 1, col)
            removeIsland(row, col - 1)
            removeIsland(row, col + 1)
        }

        var count = 0
        for (r in rowsRange) {
            for (c in colsRange) {
                if (grid[r][c] == '1') {
                    removeIsland(r, c)
                    count++
                }
            }
        }

        return count
    }
}