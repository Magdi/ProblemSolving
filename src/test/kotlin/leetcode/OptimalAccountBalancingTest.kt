package leetcode

import leetcode.uber.OptimalAccountBalancing
import org.junit.Test

import org.junit.Assert.*

class OptimalAccountBalancingTest {

    @Test
    fun `minTransfers test case 1`() {
        val transactions = arrayOf(
            intArrayOf(0, 1, 10),
            intArrayOf(2, 0, 5),
        )
        assertEquals(2, OptimalAccountBalancing().minTransfers(transactions))
    }

    @Test
    fun `minTransfers test case 2`() {
        val transactions = arrayOf(
            intArrayOf(0, 1, 10),
            intArrayOf(1, 0, 1),
            intArrayOf(1, 2, 5),
            intArrayOf(2, 0, 5),
        )
        assertEquals(1, OptimalAccountBalancing().minTransfers(transactions))
    }

    @Test
    fun `minTransfers test case 3`() {
        val transactions = arrayOf(
            intArrayOf(0, 1, 10),
            intArrayOf(1, 0, 1),
            intArrayOf(1, 2, 5),
            intArrayOf(2, 0, 4),
        )
        assertEquals(2, OptimalAccountBalancing().minTransfers(transactions))
    }

    @Test
    fun `minTransfers test case 4`() {
        val transactions = arrayOf(
            intArrayOf(0, 1, 5),
            intArrayOf(2, 3, 1),
            intArrayOf(2, 0, 1),
            intArrayOf(4, 0, 2),
        )
        assertEquals(4, OptimalAccountBalancing().minTransfers(transactions))
    }
}