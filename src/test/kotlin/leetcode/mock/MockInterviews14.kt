package leetcode.mock

import org.junit.Assert.*
import org.junit.Test
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

class MockInterview14Test {
    @Test
    fun `test case 1`() {
        assertEquals("lee(t(c)o)de", MockInterview14.minRemoveToMakeValid("lee(t(c)o)de)"))
    }


    @Test
    fun `test case 2`() {
        assertEquals(12, MockInterview14.numOfWays(1))
        assertEquals(54, MockInterview14.numOfWays(2))
    }

}

object MockInterview14 {
    fun canBeEqual(target: IntArray, arr: IntArray): Boolean {
        target.sort()
        arr.sort()
        for (i in 0 until target.size) {
            if (target[i] != arr[i]) return false
        }
        return true
    }

    fun minRemoveToMakeValid(s: String): String {
        val open = Stack<Int>()
        val remove = HashSet<Int>()
        s.forEachIndexed { i, char ->
            when (char) {
                '(' -> open.add(i)
                ')' -> {
                    if (open.isNotEmpty()) {
                        open.pop()
                    } else {
                        remove.add(i)
                    }
                }
            }
        }
        while (open.isNotEmpty()) remove.add(open.pop())
        val res = StringBuilder()
        s.forEachIndexed { index, c ->
            if (!remove.contains(index)) {
                res.append(c)
            }
        }
        return res.toString()
    }

    fun numOfWays(n: Int): Int {
        val options = ArrayList<Option>()
        generateOptions(0, 0, IntArray(3), options)
        return cnt(0, Option.BASE_OPTION, options, HashMap(), n)
    }

    private fun cnt(ind: Int, prev: Option, options: List<Option>, cache: HashMap<State, Int>, n: Int): Int {
        if (ind == n) return 1
        val state = State(ind, prev.id)
        if (cache.containsKey(state)) return cache[state]!!
        var res = 0
        options.forEach { option ->
            if (prev == Option.BASE_OPTION || prev.noMatch(option)) {
                res += cnt(ind + 1, option, options, cache, n)
                res %= 1000000007
            }
        }
        res %= 1000000007
        cache[state] = res
        return res
    }

    private data class State(val ind: Int, val prev: Int)

    private fun generateOptions(ind: Int, prev: Int, list: IntArray, options: ArrayList<Option>) {
        if (ind == 3) {
            val id = options.size
            options.add(Option(id, list[0], list[1], list[2]))
            return
        }
        for (i in 1..3) {
            if (i != prev) {
                list[ind] = i
                generateOptions(ind + 1, i, list, options)
                list[ind] = 0
            }
        }
    }

    private data class Option(val id: Int, val a: Int, val b: Int, val c: Int) {
        fun noMatch(option: Option) : Boolean {
            return (a != option.a && b != option.b && c != option.c)
        }
        companion object {
            val BASE_OPTION = Option(-1, 1, 1, 1)
        }
    }

}