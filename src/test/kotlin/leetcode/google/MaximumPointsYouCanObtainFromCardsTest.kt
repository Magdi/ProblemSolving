package leetcode.google

import org.junit.Test

import org.junit.Assert.*

class MaximumPointsYouCanObtainFromCardsTest {

    @Test
    fun `test case 1`() {
        val res = MaximumPointsYouCanObtainFromCards().maxScore(intArrayOf(1, 2, 3, 4, 5, 6, 1), 3)
        assertEquals(12, res)
    }

    @Test
    fun `test case 2`() {
        val res = MaximumPointsYouCanObtainFromCards().maxScore(intArrayOf(2, 2, 2), 2)
        assertEquals(4, res)
    }

    @Test
    fun `test case 3`() {
        val res = MaximumPointsYouCanObtainFromCards().maxScore(intArrayOf(9, 7, 7, 9, 7, 7, 9), 7)
        assertEquals(55, res)
    }

    @Test
    fun `test case 4`() {
        val res = MaximumPointsYouCanObtainFromCards().maxScore(intArrayOf(1, 1000, 1), 1)
        assertEquals(1, res)
    }

    @Test
    fun `test case 5`() {
        val res = MaximumPointsYouCanObtainFromCards().maxScore(intArrayOf(1, 79, 80, 1, 1, 1, 200, 1), 3)
        assertEquals(202, res)
    }

}