package secondAttempt.gasStation

class Solution {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        // 1 2 3 4 5  gas
        // 3 4 5 1 2  cost
        // -----
        // 0 1 2 3 4
        //
        //-2 3-2-2 3
        //-2-4-6-3 0


        // 0 -> 1: 3   15   -2
        // 1 -> 2: 4   12   -2
        // 2 -> 3: 5   8    -2
        // 3 -> 4: 1   3    3
        // 4 -> 0: 2   2    3
        // 3+4+5+1+2 = 15

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