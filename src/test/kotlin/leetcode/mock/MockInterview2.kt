package leetcode.mock

import org.junit.Assert
import org.junit.Test
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.HashMap

class MockInterview2 {

    @Test
    fun `test case 1`() {
        Assert.assertTrue(Isomorphic().isIsomorphic("aab", "bba"))
        Assert.assertFalse(Isomorphic().isIsomorphic("aabb", "bbab"))
    }

    @Test
    fun `test case 2`() {
        val room = ExamRoom(10)
        Assert.assertEquals(0, room.seat())
        Assert.assertEquals(9, room.seat())
        Assert.assertEquals(4, room.seat())
        Assert.assertEquals(2, room.seat())
        room.leave(4)
        Assert.assertEquals(5, room.seat())
    }


    @Test
    fun `test case 3`() {
        val d = Decoder()
        Assert.assertEquals("aa", d.decodeString("2[a]"))
        Assert.assertEquals("aa", d.decodeString("aa"))
        Assert.assertEquals("aaabcbc", d.decodeString("3[a]2[bc]"))
        Assert.assertEquals("accaccacc", d.decodeString("3[a2[c]]"))
    }
}

typealias CloseIndex = Int

class Decoder {

    fun decodeString(s: String): String {
        val result = StringBuilder()
        val nums = Stack<Int>()
        val strings = Stack<StringBuilder>()
        strings.add(StringBuilder())

        var index = 0
        while (index < s.length) {
            val c = s[index]
            if (c.isDigit()) {
                val end = s.indexOf('[', index)
                val num = s.substring(index, end).toInt()
                nums.add(num)
                strings.add(StringBuilder())
                index = end
            } else if (c in 'a'..'z') {
                val cur = strings.peek()
                cur.append(c)
            } else if (c == ']') {
                val r = nums.pop()
                val string = strings.pop()
                repeat(r) { strings.peek().append(string) }
            }
            index++
        }
        return strings.peek().toString()
    }
}

class ExamRoom(n: Int) {

    private val seatsCount = n
    private val takenSeats = TreeSet<Int>()

    fun seat(): Int {
        var position = 0
        if (takenSeats.isNotEmpty()) {
            var distance = takenSeats.first()
            var prev: Int? = null
            takenSeats.forEach { seat ->
                if (prev != null) {
                    val d = (seat - prev!!) / 2
                    if (distance < d) {
                        distance = d
                        position = prev!! + d
                    }
                }
                prev = seat
            }
            if (distance < seatsCount - 1 - takenSeats.last()) {
                position = seatsCount - 1
            }
        }
        takenSeats.add(position)
        return position
    }

    fun leave(p: Int) {
        takenSeats.remove(p)
    }
}

class Isomorphic {
    fun isIsomorphic(s: String, t: String): Boolean {
        val sSet = HashMap<Char, Char>()
        val tSet = HashMap<Char, Char>()
        s.forEachIndexed { index, c ->
            sSet[c] = t[index]
            tSet[t[index]] = c
        }
        s.forEachIndexed { index, c ->
            if (c != tSet[t[index]] || t[index] != sSet[c]) {
                return false
            }
        }

        return true
    }
}