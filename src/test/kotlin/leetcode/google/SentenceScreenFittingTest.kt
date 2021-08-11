package leetcode.google

import org.junit.Test

import org.junit.Assert.*

class SentenceScreenFittingTest {

    @Test
    fun `test case 1`() {
        assertEquals(
            1,
            SentenceScreenFitting().wordsTyping(arrayOf("hello", "world"), 2, 8)
        )
    }

    @Test
    fun `test case 2`() {
        assertEquals(
            2,
            SentenceScreenFitting().wordsTyping(arrayOf("a", "bcd", "e"), 3, 6)
        )
    }

    @Test
    fun `test case 3`() {
        assertEquals(
            1,
            SentenceScreenFitting().wordsTyping(arrayOf("i", "had", "apple", "pie"), 4, 5)
        )
    }

    @Test
    fun `test case 4`() {
        assertEquals(
            16,
            SentenceScreenFitting().wordsTyping(arrayOf("a", "a"), 8, 8)
        )
    }
}