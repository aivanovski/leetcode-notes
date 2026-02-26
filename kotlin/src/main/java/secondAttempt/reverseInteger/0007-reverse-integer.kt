package secondAttempt.reverseInteger

class Solution {
    fun reverse(x: Int): Int {
        var num = x
        var result = 0

        Int.MAX_VALUE //  2_147_483_647

        val max = Int.MAX_VALUE / 10
        val min = Int.MIN_VALUE / 10

        while (num != 0) {
            val digit = num % 10
            num /= 10

            if (result > max || result < min) return 0

            result = result * 10 + digit
        }

        return result
    }
}