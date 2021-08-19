package leetcode.facebook

import java.util.*
import kotlin.collections.HashMap

class Problem560 {

    fun subarraySum(nums: IntArray, k: Int): Int {
        var sum = 0
        val sumCnt = HashMap<Int, Int>()
        sumCnt[0] = 1
        var ans = 0
        nums.forEach {
            sum += it
            ans += sumCnt.getOrDefault(sum - k, 0)
            val cnt = sumCnt.getOrDefault(sum, 0)
            sumCnt[sum] = cnt + 1
        }
        return ans
    }
}