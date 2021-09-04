package leetcode

import java.util.*


class Problem16 {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        var result = nums[0] + nums[1] + nums[nums.size - 1]
        Arrays.sort(nums)

        for (start in 0 until nums.size - 2) {
            var middle = start + 1
            var end: Int = nums.size - 1
            while (middle < end) {
                val sum = nums[start] + nums[middle] + nums[end]
                if (sum == target) {
                    return target
                } else if (sum > target) {
                    while (middle < end && nums[end] == nums[end - 1]) end--
                    end--
                } else {
                    while (middle < end && nums[middle] == nums[middle + 1]) middle++
                    middle++
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum
                }
            }
        }
        return result
    }
}