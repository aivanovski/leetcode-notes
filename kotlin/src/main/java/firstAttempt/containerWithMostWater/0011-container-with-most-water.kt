package firstAttempt.containerWithMostWater

import kotlin.math.min

// https://leetcode.com/problems/container-with-most-water/description/
class Solution {
    fun maxArea(heights: IntArray): Int {
        // 2,3,10, 5, 7, 8, 9
        // 0 1  2  3  4  5  6
        // w = 4, h = 9
        if (heights.size < 2) return 0

        var left = 0
        var right = heights.lastIndex
        var maxArea = calculateArea(heights, left, right)

        while (left < right) {
            val leftHeight = heights[left]
            val rightHeight = heights[right]

            if (leftHeight < rightHeight) {
                left++
            } else {
                right--
            }

            val area = calculateArea(heights, left, right)
            if (area > maxArea) {
                maxArea = area
            }
        }

        return maxArea
    }

    private fun calculateArea(heights: IntArray, start: Int, end: Int): Int {
        val height = min(heights[start], heights[end])
        return height * (end - start)
    }
}