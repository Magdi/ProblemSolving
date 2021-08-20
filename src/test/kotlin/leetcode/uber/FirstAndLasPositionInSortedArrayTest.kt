package leetcode.uber


import leetcode.uber.FirstAndLasPositionInSortedArray
import org.junit.Assert.*
import org.junit.Test


internal class FirstAndLasPositionInSortedArrayTest {

    @Test
    fun `test case 1`() {
        val nums = intArrayOf(5, 7, 7, 8, 8, 10)
        val target = 8

        val expected = intArrayOf(3, 4)
        assertArrayEquals(expected,
            FirstAndLasPositionInSortedArray().searchRange(nums, target))
    }

    @Test
    fun `test case 2`() {
        val nums = intArrayOf(5,7,7,8,8,10)
        val target = 6

        val expected = intArrayOf(-1, -1)
        assertArrayEquals(expected,
            FirstAndLasPositionInSortedArray().searchRange(nums, target))
    }

    @Test
    fun `test case 3`() {
        val nums = intArrayOf()
        val target = 6

        val expected = intArrayOf(-1, -1)
        assertArrayEquals(expected,
            FirstAndLasPositionInSortedArray().searchRange(nums, target))
    }
}