package leetcode

import leetcode.uber.TextJustification
import org.junit.Test

import org.junit.Assert.*

class TextJustificationTest {

    @Test
    fun `test case 1`() {
        val results = TextJustification().fullJustify(
            arrayOf("This", "is", "an", "example", "of", "text", "justification."),
            16
        )
        val expected = listOf(
            "This    is    an",
            "example  of text",
            "justification.  "
        )
        assertEquals(expected, results)
    }

    @Test
    fun `test case 3`() {
        val results = TextJustification().fullJustify(
            arrayOf("shall", "be"),
            16
        )
        val expected = listOf(
            "shall be        "
        )
        assertEquals(expected, results)
    }

    @Test
    fun `test case 2`() {
        val results = TextJustification().fullJustify(
            arrayOf("Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"),
            20
        )
        val expected = listOf(
            "Science  is  what we",
            "understand      well",
            "enough to explain to",
            "a  computer.  Art is",
            "everything  else  we",
            "do                  "
        )
        assertEquals(expected, results)
    }
}