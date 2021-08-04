package leetcode.google

import org.junit.Test

import org.junit.Assert.*

class MinimumTest {

    @Test
    fun `test case 1`() {
        assertEquals(
            0,
            `Minimum Difference Between Largest and Smallest Value in Three Moves`().minDifference(
                intArrayOf(5,3,2,4)
            )
        )
    }

    @Test
    fun `test case 2`() {
        assertEquals(
            1,
            `Minimum Difference Between Largest and Smallest Value in Three Moves`().minDifference(
                intArrayOf(1,5,0,10,14)
            )
        )
    }

    @Test
    fun `test case 3`() {
        assertEquals(
            2,
            `Minimum Difference Between Largest and Smallest Value in Three Moves`().minDifference(
                intArrayOf(6,6,0,1,1,4,6)
            )
        )
    }

    @Test
    fun `test case 4`() {
        assertEquals(
            1,
            `Minimum Difference Between Largest and Smallest Value in Three Moves`().minDifference(
                intArrayOf(1,5,6,14,15)
            )
        )
    }
}