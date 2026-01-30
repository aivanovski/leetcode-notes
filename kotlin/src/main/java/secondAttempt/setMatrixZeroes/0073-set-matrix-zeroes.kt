package secondAttempt.setMatrixZeroes

class Solution {
    fun setZeroes(matrix: Array<IntArray>) {
        val rowRange = matrix.indices
        val colRange = matrix.firstOrNull()?.indices ?: IntRange.EMPTY

        val rowsToSet = HashSet<Int>()
        val colsToSet = HashSet<Int>()

        for (row in rowRange) {
            for (col in colRange) {
                if (matrix[row][col] == 0) {
                    rowsToSet.add(row)
                    colsToSet.add(col)
                }
            }
        }

        for (row in rowsToSet) {
            for (col in colRange) {
                matrix[row][col] = 0
            }
        }

        for (col in colsToSet) {
            for (row in rowRange) {
                matrix[row][col] = 0
            }
        }
    }
}