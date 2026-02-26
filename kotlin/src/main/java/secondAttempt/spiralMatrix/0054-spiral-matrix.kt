package secondAttempt.spiralMatrix

class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val rows = matrix.size
        val cols = matrix.first().size

        var left = 0
        var right = cols - 1
        var top = 0
        var bottom = rows - 1

        // 123
        // 456
        // 789

        // 3
        // 2

        val result = mutableListOf<Int>()
        while (left <= right && top <= bottom) {
            for (c in left..right) {
                result.add(matrix[top][c])
            }
            top++

            for (r in top..bottom) {
                result.add(matrix[r][right])
            }
            right--

            if (top > bottom || left > right) break

            for (c in right downTo left) {
                result.add(matrix[bottom][c])
            }
            bottom--

            for (r in bottom downTo top) {
                result.add(matrix[r][left])
            }
            left++
        }

        return result
    }
}