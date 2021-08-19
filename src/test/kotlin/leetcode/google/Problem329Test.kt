package leetcode.google

import org.junit.Test

import org.junit.Assert.*

class Problem329Test {

    @Test
    fun `test case 1`() {
        assertEquals(
            4,
            Problem329().longestIncreasingPath(
                arrayOf(
                    intArrayOf(9, 9, 4),
                    intArrayOf(6, 6, 8),
                    intArrayOf(2, 1, 1),
                )
            )
        )
    }
}