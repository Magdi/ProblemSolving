package leetcode.uber

import leetcode.uber.JumpGameVI
import org.junit.Test

import org.junit.Assert.*

class JumpGameVITest {

    @Test
    fun `test case 1`() {
        val result = JumpGameVI().maxResult(intArrayOf(1, -1, -2, 4, -7, 3), 2)
        assertEquals(7, result)
    }

    @Test
    fun `test case 2`() {
        val result = JumpGameVI().maxResult(intArrayOf(10, -5, -2, 4, 0, 3), 3)
        assertEquals(17, result)
    }

    @Test
    fun `test case 3`() {
        val result = JumpGameVI().maxResult(intArrayOf(1, -5, -20, 4, -1, 3, -6, -3), 2)
        assertEquals(0, result)
    }

}