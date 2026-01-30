package firstAttempt.setMatrixZeroes

class Solution {
    fun setZeroes(matrix: Array<IntArray>) {
        val rows = matrix.size
        val columns = matrix.firstOrNull()?.size ?: 0

        val rowsToSet = HashSet<Int>()
        val columnsToSet = HashSet<Int>()

        for (r in 0 until rows) {
            for (c in 0 until columns) {
                if (matrix[r][c] == 0) {
                    rowsToSet.add(r)
                    columnsToSet.add(c)
                }
            }
        }

        for (r in rowsToSet) {
            for (c in 0 until columns) {
                matrix[r][c] = 0
            }
        }

        for (c in columnsToSet) {
            for (r in 0 until rows) {
                matrix[r][c] = 0
            }
        }
    }
}