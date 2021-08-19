package leetcode.google

import org.junit.Test

import org.junit.Assert.*

class TimeMapTest {

    @Test
    fun `test case 1`() {
        val timemap = TimeMap()
        timemap.set("foo", "bar", 1)
        assertEquals("bar", timemap.get("foo", 1))
        assertEquals("bar", timemap.get("foo", 3))
        assertEquals("", timemap.get("foo", 0))
        timemap.set("foo", "bar2", 4)
        assertEquals("bar2", timemap.get("foo", 4))
        assertEquals("bar2", timemap.get("foo", 5))
        assertEquals("bar", timemap.get("foo", 3))
    }
}