package secondAttempt.rotateImage

class Solution {
    fun rotate(matrix: Array<IntArray>) {
        val n = matrix.size

        var l = 0
        var r = n - 1
        while (l < r) {

            for (i in l until r) {
                val topLeft = matrix[l][i] // [1][1]
                val topRight = matrix[i][r] // [1][2]
                val bottomRight = matrix[r][r - (i - l)] // [2][1] => 2 - 1
                val bottomLeft = matrix[r - (i - l)][l] //

                matrix[l][i] = bottomLeft
                matrix[i][r] = topLeft
                matrix[r][r - (i - l)] = topRight
                matrix[r - (i - l)][l] = bottomRight
            }

            l++
            r--
        }
    }
}