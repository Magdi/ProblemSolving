package leetcode

import leetcode.uber.ConstructKPalindromeStrings
import org.junit.Test

import org.junit.Assert.*

class ConstructKPalindromeStringsTest {

    @Test
    fun `test case 1`() {
        assertTrue(ConstructKPalindromeStrings().canConstruct("annabelle", 2))
    }

    @Test
    fun `test case 2`() {
        assertFalse(ConstructKPalindromeStrings().canConstruct("leetcode", 3))
    }

    @Test
    fun `test case 3`() {
        assertTrue(ConstructKPalindromeStrings().canConstruct("true", 4))
    }

    @Test
    fun `test case 4`() {
        assertTrue(ConstructKPalindromeStrings().canConstruct("yzyzyzyzyzyzyzy", 2))
    }

    @Test
    fun `test case 5`() {
        assertFalse(ConstructKPalindromeStrings().canConstruct("cr", 7))
    }
}