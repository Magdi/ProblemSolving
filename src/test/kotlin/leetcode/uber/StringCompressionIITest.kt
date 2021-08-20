package leetcode.uber

import leetcode.uber.StringCompressionII
import org.junit.Test

import org.junit.Assert.*

class StringCompressionIITest {

    @Test
    fun `test case 1`() {
        assertEquals(4, StringCompressionII().getLengthOfOptimalCompression("aaabcccd", 2))

    }

    @Test
    fun `test case 2`() {
        assertEquals(2, StringCompressionII().getLengthOfOptimalCompression("aabbaa", 2))
    }

    @Test
    fun `test case 3`() {
        assertEquals(3, StringCompressionII().getLengthOfOptimalCompression("aaaaabbbbbaaaaaa", 5))
    }

    @Test
    fun `test case 5`() {
        assertEquals(2, StringCompressionII().getLengthOfOptimalCompression("aaaaabbbbbaaaaaa", 7))
    }

    @Test
    fun `test case 6`() {
        assertEquals(3, StringCompressionII().getLengthOfOptimalCompression("bbabbbabbbbcbb", 4))
    }

    @Test
    fun `test case 4`() {
        assertEquals(3, StringCompressionII().getLengthOfOptimalCompression("aaaaaaaaaaa", 0))
    }
}