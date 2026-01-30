package firstAttempt.sumOfTwoIntegers

class Solution {
    fun getSum(a: Int, b: Int): Int {
        // for every bit

        // 001 = 1
        // 010 = 2
        // 011 = 3
        // 100 = 4
        // 101 = 5
        // 110 = 6
        // 111 = 7

        // 011
        //+011
        //----
        //  10
        // 10

        var result = 0
        var carry = 0
        for (i in 0..31) {
            val mask = 1 shl i
            val ba = if ((a and mask) != 0) 1 else 0
            val bb = if ((b and mask) != 0) 1 else 0

            val bitsum = (ba xor bb)
            val sum = bitsum xor carry

            carry = if ((ba == 1 && bb == 1) || (bitsum == 1 && carry == 1)) 1 else 0

            result = result or (sum shl i)
        }

        return result
    }
}