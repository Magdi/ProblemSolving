package leetcode.google

/**
 * https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/
 */
class Problem1526 {
    // O ( N )
    fun minNumberOperations(target: IntArray): Int {
        val target = target.toMutableList()
        target.add(0, 0)
        target.add(0)
        var ans = 0
        for (i in 1..target.size - 2) {
            if (target[i] > target[i - 1]) { // local max
                ans += (target[i] - target[i - 1])
            }
        }
        return ans
    }
}