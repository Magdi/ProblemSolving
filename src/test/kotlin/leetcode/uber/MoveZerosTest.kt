package leetcode.uber

import leetcode.uber.MoveZeros
import org.junit.Assert.*
import org.junit.Test

class MoveZerosTest {
    @Test
    fun `test case 1`() {
        val input = intArrayOf(0,1,0,3,12)
        MoveZeros().moveZeroes(input)

        val expected = intArrayOf(1,3,12,0,0)
        assertArrayEquals(expected, input)
    }
}