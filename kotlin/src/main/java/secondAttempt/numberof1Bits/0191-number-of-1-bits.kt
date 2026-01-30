package secondAttempt.numberof1Bits

class Solution {
    fun hammingWeight(n: Int): Int {
        return (0..31).map { i -> (n and (1 shl i)) shr i }.sum()
    }
}