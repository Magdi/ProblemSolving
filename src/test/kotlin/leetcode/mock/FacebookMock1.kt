package leetcode.mock

import org.junit.Assert.*
import org.junit.Test

class MockInterviewFacebook1Test {
    @Test
    fun `test case 1`() {
        assertEquals(3, MockInterviewFacebook1.findLengthOfLCIS(intArrayOf(1, 3, 5, 3, 7)))
        assertEquals(1, MockInterviewFacebook1.findLengthOfLCIS(intArrayOf(1)))
    }

    @Test
    fun `test case 2`() {
        assertEquals(3, MockInterviewFacebook1.numberOfArithmeticSlices(intArrayOf(1, 2, 3, 4)))
        assertEquals(6, MockInterviewFacebook1.numberOfArithmeticSlices(intArrayOf(1, 2, 3, 4, 5)))
        assertEquals(0, MockInterviewFacebook1.numberOfArithmeticSlices(intArrayOf(1, 2, 1, 4, 5)))
    }
}

object MockInterviewFacebook1 {
    fun findLengthOfLCIS(nums: IntArray): Int {
        var ans = 1
        var cur = 1
        for (i in 1 until nums.size) {
            if (nums[i] > nums[i - 1]) {
                cur++
                ans = Math.max(ans, cur)
            } else {
                cur = 1
            }
        }
        return ans
    }

    fun numberOfArithmeticSlices(nums: IntArray): Int {
        if (nums.size < 3) return 0
        var cnt = 0
        var size = 2
        var diff = nums[1] - nums[0]
        val cache = HashMap<Int, Int>()
        for (i in 2 until nums.size) {
            if (nums[i] - nums[i - 1] == diff) {
                size++
                cnt += cnt(size, cache) - cnt(size - 1, cache)
            } else {
                size = 2
                diff = nums[i] - nums[i - 1]
            }
        }
        return cnt
    }

    private fun cnt(size: Int, cache: HashMap<Int, Int>): Int {
        if (cache.containsKey(size)) return cache[size]!!
        val ans = if (size < 3) 0
        else if (size == 3) 1
        else {
            var cnt = 0
            for (s in size downTo 3) {
                cnt += (size - s) + 1
            }
            cnt
        }
        cache[size] = ans
        return ans
    }
}