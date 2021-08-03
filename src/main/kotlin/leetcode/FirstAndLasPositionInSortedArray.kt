package leetcode


class FirstAndLasPositionInSortedArray {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        if (nums.isEmpty()) return intArrayOf(-1, -1)
        val start = findBound(nums = nums, target = target, startBound = true)
        if (start == -1) return intArrayOf(-1, -1)
        val end = findBound(nums = nums, target = target, startBound = false)
        return intArrayOf(start, end)
    }

    private fun findBound(nums: IntArray, target: Int, startBound: Boolean): Int {
        var start = 0
        var end = nums.size - 1
        while (start <= end) {
            val mid = (start + end) / 2
            if (nums[mid] == target) {
                if (startBound) { // find lower bound
                    if (mid == start || nums[mid - 1] != target) {
                        return mid
                    }
                    end = mid - 1
                } else {
                    if (mid == end || nums[mid + 1] != target) {
                        return mid
                    }
                    start = mid + 1
                }
            } else if (nums[mid] > target) {
                end = mid - 1
            } else {
                start = mid + 1
            }
        }
        return -1
    }
}