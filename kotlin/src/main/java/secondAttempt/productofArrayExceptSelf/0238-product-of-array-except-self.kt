package secondAttempt.productofArrayExceptSelf

class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        // 1  2  3  4

        // 1  2  6 24
        //24 24 12  4

        val n = nums.size
        val products = Array(2) { IntArray(n) }

        var rightProduct = 1
        var leftProduct = 1

        for (i in 0 until n) {
            rightProduct *= nums[i]
            leftProduct *= nums[nums.lastIndex - i]

            products[0][i] = rightProduct
            products[1][nums.lastIndex - i] = leftProduct
        }

        val result = IntArray(n)
        for (i in 0 until n) {
            result[i] = (products[0].getOrNull(i - 1) ?: 1) * (products[1].getOrNull(i + 1) ?: 1)
        }

        return result
    }
}