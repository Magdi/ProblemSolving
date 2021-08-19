package leetcode.google

import org.junit.Test

import org.junit.Assert.*

class Problem871Test {

    @Test
    fun `test case 1`() {
        val ans = Problem871().minRefuelStops(
            100, 10,
            arrayOf(
                intArrayOf(10, 60),
                intArrayOf(20, 30),
                intArrayOf(30, 30),
                intArrayOf(60, 40),
            )
        )
        assertEquals(2, ans)
    }

    @Test
    fun `test case 2`() {
        val ans = Problem871().minRefuelStops(
            1, 1,
            arrayOf(
            )
        )
        assertEquals(0, ans)
    }

    @Test
    fun `test case 3`() {
        val ans = Problem871().minRefuelStops(
            100, 50,
            arrayOf(
                intArrayOf(25, 25),
                intArrayOf(50, 50),
            )
        )
        assertEquals(0, ans)
    }
}