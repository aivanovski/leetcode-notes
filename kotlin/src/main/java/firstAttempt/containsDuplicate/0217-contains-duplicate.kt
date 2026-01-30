package firstAttempt.containsDuplicate

// https://leetcode.com/problems/contains-duplicate/description/
class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        val set = HashSet<Int>(nums.size)
        return nums.any { num ->
            if (set.contains(num)) {
                true
            } else {
                set.add(num)
                false
            }
        }
    }
}