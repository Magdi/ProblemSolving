package leetcode.google

/**
 * https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/
 */
class `Minimum Difference Between Largest and Smallest Value in Three Moves` {
    fun minDifference(nums: IntArray): Int {
        val sorted = nums.sorted().toList()
        if (sorted.size <= 4) {
            return 0
        }
        var minDiff = sorted.last() - sorted.first()
        for (i in 0..3) {
            val min = sorted[i]
            val max = sorted[sorted.lastIndex - (3 - i)]
             minDiff = Math.min(minDiff, max - min)
        }
        return minDiff
    }

}