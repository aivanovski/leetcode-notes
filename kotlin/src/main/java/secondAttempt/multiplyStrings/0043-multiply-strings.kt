package secondAttempt.multiplyStrings

import java.util.LinkedList

class Solution {
    fun multiply(num1: String, num2: String): String {

        // 123
        // 456
        // ---
        // 123 * 6
        // (123 * 5) * 10
        // (123 * 4) * 100
        // ---
        // 123 * 6 => 3 * 6 + (2 * 6) <<+ 0 + (1 * 6) <<+ 00
        // 123 * 5 => () <<+ 0
        // 123 * 4 => () <<+ 00

        var sum = "0"
        for (i in 0 until num2.length) {
            val n2 = num2[num2.lastIndex - i].toString().toInt()
            val m = multiply(num1, n2)
            if (m == "0") continue

            sum = sum(shift(m, i), sum)
        }

        return sum
    }

    fun multiply(num: String, multiplier: Int): String {
        var sum = "0"

        for (i in 0 until num.length) {
            val n = num[num.lastIndex - i].toString().toInt()
            val m = n * multiplier
            if (m == 0) continue

            sum = sum(shift(m.toString(), i), sum)
        }

        return sum
    }

    private fun shift(num: String, numOfZero: Int): String {
        if (numOfZero == 0) return num
        return num + "0".repeat(numOfZero)
    }

    fun sum(num1: String, num2: String): String {
        val result = LinkedList<Int>()

        var carry = 0
        val len = maxOf(num1.length, num2.length)
        for (i in 0 until len) {
            val n1 = num1.getOrNull(num1.lastIndex - i)
                ?.let { it.toString().toInt() }
                ?: 0

            val n2 = num2.getOrNull(num2.lastIndex - i)
                ?.let { it.toString().toInt() }
                ?: 0

            var sum = n1 + n2 + carry

            if (sum > 9) {
                carry = 1
                sum = sum % 10
            } else {
                carry = 0
            }

            result.push(sum)
        }

        if (carry == 1) {
            result.push(1)
        }

        return result.joinToString(separator = "")
    }
}