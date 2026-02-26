package secondAttempt.carFleet

class Solution {
    fun carFleet(
        target: Int,
        positions: IntArray,
        speeds: IntArray
    ): Int {
        val n = positions.size

        val params = positions.zip(speeds)
            .sortedBy { (position, _) -> position }

        var fleets = 1
        var prevTime = params.last().let { (p, s) -> calculateTime(target, p, s) }

        for (i in n - 1 downTo 0) {
            val (position, speed) = params[i]
            val time = calculateTime(target, position, speed)
            if (time > prevTime) {
                prevTime = time
                fleets++
            }
        }

        return fleets
    }

    private fun calculateTime(target: Int, position: Int, speed: Int): Double {
        return (target - position) / speed.toDouble()
    }
}