package leetcode.uber

/**
 * https://leetcode.com/problems/move-zeroes/
 *
 * Given an integer array nums, move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
    Note that you must do this in-place without making a copy of the array.
 */
class MoveZeros {
    fun moveZeroes(nums: IntArray): Unit {
        var zeroCount = 0
        nums.forEachIndexed { index, num ->
            if (num == 0) {
                zeroCount++
            } else {
                nums[index - zeroCount] = nums[index]
                if (zeroCount > 0) {
                    nums[index] = 0
                }
            }
        }
    }
}