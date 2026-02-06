package secondAttempt.containerWithMostWater

class Solution {
    fun maxArea(heights: IntArray): Int {
        // 186254837
        // 012345678
        //

        var left = 0
        var right = heights.lastIndex
        var maxArea = 0

        while (left < right) {
            val leftHeight = heights[left]
            val rightHeight = heights[right]
            val area = minOf(leftHeight, rightHeight) * (right - left)

            if (leftHeight < rightHeight) {
                left++
            } else if (leftHeight > rightHeight) {
                right--
            } else {
                left++
            }

            maxArea = maxOf(maxArea, area)
        }

        return maxArea
    }
}