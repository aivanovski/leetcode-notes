package secondAttempt.gasStation

class Solution {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        val n = gas.size
        val gasDelta = IntArray(n)
        var sumGas = 0
        var sumCost = 0
        for (i in 0 until n) {
            gasDelta[i] = gas[i] - cost[i]
            sumGas += gas[i]
            sumCost += cost[i]
        }

        if (sumGas < sumCost) return -1

        var total = 0
        var start = 0
        for (i in 0 until n) {
            if (total + gasDelta[i] < 0) {
                total = 0
            } else {
                if (total == 0) {
                    start = i
                }
                total += gasDelta[i]
            }
        }

        return start
    }
}
