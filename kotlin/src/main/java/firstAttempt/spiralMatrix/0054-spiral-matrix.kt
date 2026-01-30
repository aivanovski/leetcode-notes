package firstAttempt.spiralMatrix

import kotlin.math.max
import kotlin.math.min

class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val rows = matrix.size
        val cols = matrix.first().size

        if (rows == 0 || cols == 0) return matrix.firstOrNull()?.toList() ?: emptyList()

        val result = mutableListOf<Int>()

        var left = 0
        var right = cols - 1
        var top = 0
        var bottom = rows - 1

        while (left <= right && top <= bottom) {
            for (i in left..right) {
                result.add(matrix[top][i])
            }
            top++

            for (i in top..bottom) {
                result.add(matrix[i][right])
            }
            right--

            if (top > bottom || left > right) {
                break
            }

            for (i in right downTo left) {
                result.add(matrix[bottom][i])
            }
            bottom--

            for (i in bottom downTo top) {
                result.add(matrix[i][left])
            }
            left++
        }

        return result
    }
}