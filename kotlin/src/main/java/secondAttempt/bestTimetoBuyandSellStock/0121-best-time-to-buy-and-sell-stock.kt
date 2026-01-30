package secondAttempt.bestTimetoBuyandSellStock

import kotlin.math.max

class Solution {
    fun maxProfit(prices: IntArray): Int {
        var buyPrice = prices.first()
        var sellPrice = prices.first()
        var maxProfit = sellPrice - buyPrice

        for (i in 1 until prices.size) {
            val price = prices[i]
            if (price > buyPrice) {
                sellPrice = price
                maxProfit = max(maxProfit, sellPrice - buyPrice)
            } else if (price < buyPrice) {
                buyPrice = price
                sellPrice = price
            }
        }

        return maxProfit
    }
}