package firstAttempt.numberOfIslands

import java.util.LinkedList

// https://leetcode.com/problems/number-of-islands/description/
class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        val rows = grid.size
        val cols = grid[0].size

        val visited = Array(rows, init = { BooleanArray(cols) })

        var count = 0
        for (row in 0 until rows) {
            for (col in 0 until cols) {
                if (!visited[row][col] && grid[row][col] == '1') {
                    markIsland(grid, visited, row, col)
                    count++
                }

                visited[row][col] = true
            }
        }

        return count
    }

    private fun markIsland(
        grid: Array<CharArray>,
        visited: Array<BooleanArray>,
        row: Int,
        col: Int
    ) {
        // 11
        // 10
        val queue = LinkedList<Pair<Int, Int>>()
            .apply {
                add(row to col)
            }

        val rowRange = grid.indices
        val colRange = grid.first().indices

        while (queue.isNotEmpty()) {
            val (row, col) = queue.removeFirst()
            if (visited[row][col]) continue

            visited[row][col] = true

            if (grid[row][col] == '1') {
                for ((dr, dc) in DESTINATIONS) {
                    val nextRow = row + dr
                    val nextCol = col + dc

                    if (nextRow in rowRange
                        && nextCol in colRange
                        && !visited[nextRow][nextCol]
                        && grid[nextRow][nextCol] == '1'
                    ) {
                        queue.add(nextRow to nextCol)
                    }
                }
            }
        }
    }

    companion object {
        private val DESTINATIONS = listOf(
            1 to 0,
            -1 to 0,
            0 to 1,
            0 to -1
        )
    }
}