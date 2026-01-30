package secondAttempt.pacificAtlanticWaterFlow

import java.util.LinkedList

class Solution {
    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        // 111
        // 121
        // 111

        // create 2 flow tables
        // mark initial points for each of the flow
        // use dfs to mark reachable points from initial points
        // find intersections between 2 flow tables

        val rows = heights.size
        if (rows == 0) return emptyList()

        val cols = heights[0].size

        val pflow = Array(rows) { IntArray(cols) }
        val aflow = Array(rows) { IntArray(cols) }

        markInitialPacificFlow(heights, pflow)
        markInitialAtlanticFlow(heights, aflow)

        val pvisited = Array(rows) { IntArray(cols) }
        for (row in 0 until rows) {
            for (col in 0 until cols) {
                if (pvisited[row][col] == 0 && pflow[row][col] == 1) {
                    markReachablePoints(row to col, heights, pflow, pvisited)
                }
            }
        }

        val avisited = Array(rows) { IntArray(cols) }
        for (row in 0 until rows) {
            for (col in 0 until cols) {
                if (avisited[row][col] == 0 && aflow[row][col] == 1) {
                    markReachablePoints(row to col, heights, aflow, avisited)
                }
            }
        }

        val result = mutableListOf<List<Int>>()
        for (row in 0 until rows) {
            for (col in 0 until cols) {
                if (aflow[row][col] == 1 && pflow[row][col] == 1) {
                    result.add(listOf(row, col))
                }
            }
        }

        return result
    }

    private fun markReachablePoints(
        start: Pair<Int, Int>,
        heights: Array<IntArray>,
        flow: Array<IntArray>,
        visited: Array<IntArray>
    ) {
        val rows = heights.size
        val cols = heights[0].size

        val stack = LinkedList<Pair<Int, Int>>()
            .apply {
                add(start)
            }

        val rowRange = heights.indices
        val colRange = heights[0].indices

        while (stack.isNotEmpty()) {
            val (row, col) = stack.pop()

            visited[row][col] = 1
            flow[row][col] = 1

            for ((dr, dc) in DIRECTIONS) {
                val nextRow = row + dr
                val nextCol = col + dc

                if (nextRow in rowRange
                    && nextCol in colRange
                    && visited[nextRow][nextCol] == 0 // should be marked
                    && flow[nextRow][nextCol] == 0
                    && heights[nextRow][nextCol] >= heights[row][col]
                ) {
                    stack.push(nextRow to nextCol)
                }
            }
        }
    }

    private fun markInitialPacificFlow(
        heights: Array<IntArray>,
        flow: Array<IntArray>
    ) {
        val rows = heights.size
        val cols = heights[0].size

        for (col in 0 until cols) flow[0][col] = 1
        for (row in 1 until rows) flow[row][0] = 1
    }

    private fun markInitialAtlanticFlow(
        heights: Array<IntArray>,
        flow: Array<IntArray>
    ) {
        val rows = heights.size
        val cols = heights[0].size

        for (col in 0 until cols) flow[rows - 1][col] = 1
        for (row in rows - 2 downTo 0) flow[row][cols - 1] = 1
    }

    companion object {
        private val DIRECTIONS = listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)
    }
}