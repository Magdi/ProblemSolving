package leetcode.google

import org.junit.Test

import org.junit.Assert.*

class CarFleetTest {

    @Test
    fun carFleet() {
        assertEquals(
            3,
            CarFleet().carFleet(12, intArrayOf(10, 8, 0, 5, 3), intArrayOf(2, 4, 1, 1, 3))
        )
    }

    @Test
    fun `test case 1`() {
        assertEquals(
            1,
            CarFleet().carFleet(10, intArrayOf(0, 4, 2), intArrayOf(2, 1, 3))
        )
    }
}