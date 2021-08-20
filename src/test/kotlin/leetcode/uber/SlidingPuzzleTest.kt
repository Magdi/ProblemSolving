package leetcode.uber

import leetcode.uber.SlidingPuzzle
import org.junit.Test

import org.junit.Assert.*

class SlidingPuzzleTest {

    @Test
    fun `test case 1`() {
        val res = SlidingPuzzle().slidingPuzzle(arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 0, 5)))
        assertEquals(1, res)
    }

    @Test
    fun `test case 2`() {
        val res = SlidingPuzzle().slidingPuzzle(arrayOf(intArrayOf(1, 2, 3), intArrayOf(5, 4, 0)))
        assertEquals(-1, res)
    }

    @Test
    fun `test case 3`() {
        val res = SlidingPuzzle().slidingPuzzle(arrayOf(intArrayOf(4, 1, 2), intArrayOf(5, 0, 3)))
        assertEquals(5, res)
    }

    @Test
    fun `test case 4`() {
        val res = SlidingPuzzle().slidingPuzzle(arrayOf(intArrayOf(3, 2, 4), intArrayOf(1, 5, 0)))
        assertEquals(14, res)
    }
}