package secondAttempt.sumofTwoIntegers

class Solution {
    fun getSum(a: Int, b: Int): Int {

        // 1: 001
        // 2: 010
        // 4: 100
        // 7: 111

        // 0111
        // 0111
        // ____
        //

        var sum = 0
        var carry = 0

        for (i in 0..31) {
            val bita = (a and (1 shl i)) shr i
            val bitb = (b and (1 shl i)) shr i

            val bit = (bita xor bitb) xor carry
            carry = if ((bita == 1 && bitb == 1) || (carry == 1 && (bita == 1 || bitb == 1))) {
                1
            } else {
                0
            }

            sum = sum xor (bit shl i)

        }

        return sum
    }
}