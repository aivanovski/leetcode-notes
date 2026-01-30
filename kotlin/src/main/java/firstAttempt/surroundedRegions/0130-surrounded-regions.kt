package firstAttempt.surroundedRegions

import java.util.LinkedList

class Solution {
    fun solve(board: Array<CharArray>) {
        // -1 non-capturable
        // 0  not visited
        // 1 captured

        val rows = board.size
        val cols = board.firstOrNull()?.size ?: 0

        val state = Array(rows) { IntArray(cols) }

        // Mark non-capturable cells
        for ((row, col) in getInitialNonCapturableCells(board)) {
            if (board[row][col] == 'O' && state[row][col] == STATE_NOT_VISITED) {
                markNonCapturable(row to col, board, state)
            }
        }

        // Mark not visited cells as captured
        for (row in 0 until rows) {
            for (col in 0 until cols) {
                if (board[row][col] == 'O' && state[row][col] != STATE_NON_CAPTURABLE) {
                    board[row][col] = 'X'
                }
            }
        }
    }

    private fun getInitialNonCapturableCells(board: Array<CharArray>): List<Pair<Int, Int>> {
        val cells = mutableListOf<Pair<Int, Int>>()

        val rows = board.size
        val cols = board.firstOrNull()?.size ?: 0

        for (c in 0 until cols) {
            cells.add(0 to c)
            cells.add((rows - 1) to c)
        }
        for (r in 1 until rows - 1) {
            cells.add(r to 0)
            cells.add(r to (cols - 1))
        }

        return cells
    }

    private fun markNonCapturable(
        start: Pair<Int, Int>,
        board: Array<CharArray>,
        state: Array<IntArray>
    ) {
        val queue = LinkedList<Pair<Int, Int>>()
            .apply {
                add(start)
            }

        val rowRange = 0 until board.size
        val colRange = 0 until (board.firstOrNull()?.size ?: 0)

        while (queue.isNotEmpty()) {
            val (row, col) = queue.pop()

            val value = board[row][col]
            if (value == 'O') {
                if (state[row][col] == STATE_NOT_VISITED) {
                    state[row][col] = STATE_NON_CAPTURABLE

                    for ((dr, dc) in DIRECTIONS) {
                        val nextRow = row + dr
                        val nextCol = col + dc

                        if (nextRow in rowRange
                            && nextCol in colRange
                            && board[nextRow][nextCol] == 'O'
                            && state[nextRow][nextCol] == STATE_NOT_VISITED
                        ) {
                            queue.add(nextRow to nextCol)
                        }
                    }
                }
            }
        }
    }

    companion object {
        private val STATE_NON_CAPTURABLE = -1
        private val STATE_NOT_VISITED = 0
        private val STATE_CAPTURED = 1

        private val DIRECTIONS = listOf(
            -1 to 0,
            1 to 0,
            0 to -1,
            0 to 1
        )
    }
}