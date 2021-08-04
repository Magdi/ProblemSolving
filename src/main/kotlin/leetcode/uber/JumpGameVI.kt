package leetcode.uber

import java.util.*
import kotlin.Comparator
import kotlin.collections.HashMap

class JumpGameVI {

    fun maxResult(nums: IntArray, k: Int): Int {
//        val cache = hashMapOf<Int, Int>()
//        return maximize(0, nums, k, cache)
        return calc(nums, k)
    }

    // O (n log k*)
    private fun calc(nums: IntArray, k: Int): Int {
        val n = nums.size
        val cache = IntArray(n)
        cache[0] = nums[0]
        val q = PriorityQueue(Comparator<Pair<Int, Int>> { p0, p1 ->
            p1.first.compareTo(p0.first)
        })
        q.add(Pair(nums[0], 0))
        for (i in 1 until n) {
            while (q.peek().second < i - k) {
                q.remove()
            }
            cache[i] = nums[i] + cache[q.peek().second]
            q.add(Pair(cache[i], i))
        }

        return cache[n - 1]
    }

    // o ( n * k )
    private fun maximize(index: Int, nums: IntArray, k: Int, cache: HashMap<Int, Int>): Int {
        if (index == nums.size - 1) return nums[index]
        if (cache[index] != null) return cache[index]!!
        var max = Int.MIN_VALUE
        for (i in 1..k) {
            if (index + i < nums.size) {
                max = Math.max(max, maximize(index + i, nums, k, cache))
            }
        }
        max += nums[index]
        cache[index] = max
        return max
    }
}