package leetcode.google

import org.junit.Test

import org.junit.Assert.*

class CarFleetIITest {

    @Test
    fun `test case 1`() {
        val answer = CarFleetII().getCollisionTimes(
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(2, 1),
                intArrayOf(4, 3),
                intArrayOf(7, 2),
            )
        )
        val expected = doubleArrayOf(1.00000, -1.00000, 3.00000, -1.00000)
        expected.forEachIndexed { index, d ->
            assertEquals(d, answer[index], .00001)
        }
    }

    @Test
    fun `test case 2`() {
        val answer = CarFleetII().getCollisionTimes(
            arrayOf(
                intArrayOf(3, 4),
                intArrayOf(5, 4),
                intArrayOf(6, 3),
                intArrayOf(9, 1),
            )
        )
        val expected = doubleArrayOf(1.00000, -1.00000, 3.00000, -1.00000)
        expected.forEachIndexed { index, d ->
            assertEquals(d, answer[index], .00001)
        }
    }
}