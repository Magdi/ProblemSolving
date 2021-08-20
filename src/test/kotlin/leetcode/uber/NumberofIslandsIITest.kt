package leetcode.uber

import leetcode.uber.NumberofIslandsII
import org.junit.Test

import org.junit.Assert.*

class NumberofIslandsIITest {

    @Test
    fun `test case 1`() {
        val positions = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(0, 1),
            intArrayOf(1, 2),
            intArrayOf(2, 1),
        )
        val answer = NumberofIslandsII().numIslands2(3, 3, positions)
        val expected = listOf(1, 1, 2, 3)
        assertEquals(expected, answer)
    }

    @Test
    fun `test case 2`() {
        val positions = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(0, 2),
            intArrayOf(0, 1),
            intArrayOf(2, 1),
        )
        val answer = NumberofIslandsII().numIslands2(3, 3, positions)
        val expected = listOf(1, 2, 1, 2)
        assertEquals(expected, answer)
    }

    @Test
    fun `test case 3`() {
        val positions = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(0, 1),
            intArrayOf(1, 2),
            intArrayOf(1, 2),
        )
        val answer = NumberofIslandsII().numIslands2(3, 3, positions)
        val expected = listOf(1, 2, 1, 2)
        assertEquals(expected, answer)
    }
}