package firstAttempt.rotateImage

// https://leetcode.com/problems/rotate-image/description/
class Solution {
    fun rotate(matrix: Array<IntArray>) {
        val rows = matrix.size
        val cols = matrix.first().size

        val iterations = cols / 2
        for (i in 0 until iterations) {
            rotate(matrix, Spec(i, i, cols - i * 2, rows - i * 2))
        }
    }

    private fun rotate(matrix: Array<IntArray>, spec: Spec) {
        val dc = spec.dc
        val dr = spec.dr
        val cols = spec.width
        val rows = spec.height

        for (index in 0 until spec.width - 1) {
            val top = matrix[0 + dr][index + dc]
            val right = matrix[index + dr][cols - 1 + dc]
            val bottom = matrix[rows - 1 + dr][cols - 1 - index + dc]
            val left = matrix[rows - 1 - index + dr][0 + dc]

            matrix[0 + dr][index + dc] = left
            matrix[index + dr][cols - 1 + dc] = top
            matrix[rows - 1 + dr][cols - 1 - index + dc] = right
            matrix[rows - 1 - index + dr][0 + dc] = bottom
        }
    }

    data class Spec(
        val dc: Int,
        val dr: Int,
        val width: Int,
        val height: Int
    )
}