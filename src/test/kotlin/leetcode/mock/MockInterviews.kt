package leetcode

import org.junit.Test

import org.junit.Assert.*
import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet

class MockInterviews1Test {
    @Test
    fun `test case 1`() {
        assertEquals("", MockSolution1().removeDuplicates("aa"))
        assertEquals("a", MockSolution1().removeDuplicates("aaa"))
        assertEquals("ba", MockSolution1().removeDuplicates("aaba"))
        assertEquals("ay", MockSolution1().removeDuplicates("azxxzy"))
    }

    @Test
    fun `test case 2`() {
        assertArrayEquals(
            arrayOf("acdf", "acef", "bcdf", "bcef"),
            MockSolution2().expand("{a,b}c{d,e}f")
        )
    }

    @Test
    fun `test case 3`() {
        val checker = StreamChecker(arrayOf("ab", "ba", "aaab", "abab", "baa"))
        assertFalse(checker.query('b'))
        assertTrue(checker.query('a'))
        assertTrue(checker.query('b'))
    }
}


/**
 * Stream of Characters
 */
private class StreamChecker(words: Array<String>) {
    private val trie = Trie()
    private var maxLength = 0

    init {
        words.forEach {
            trie.add(it.reversed())
            maxLength = Math.max(maxLength, it.length)
        }
    }

    var currentString = StringBuilder()

    fun query(letter: Char): Boolean {
        currentString.append(letter)
        return trie.find(currentString, maxLength)
    }


    private class Trie(private val root: TrieNode = TrieNode()) {
        fun add(s: String) {
            var cur = root
            s.forEachIndexed { index, c ->
                cur = cur.add(c, index == s.lastIndex)
            }
        }

        fun find(sb: StringBuilder, maxLength: Int): Boolean {
            var cur = root
            for (i in 0 until Math.min(maxLength, sb.length)) {
                val next = cur.find(sb[sb.lastIndex - i])
                if (next == null) {
                    return false
                } else if (next.isEnd) {
                    return true
                } else {
                    cur = next
                }
            }
            return false
        }
    }

    private class TrieNode(private val charMap: HashMap<Char, TrieNode> = HashMap(), var isEnd: Boolean = false) {
        fun add(c: Char, isEnd: Boolean): TrieNode {
            val node = charMap.getOrDefault(c, TrieNode())
            node.isEnd = isEnd or node.isEnd
            charMap[c] = node
            return node
        }

        fun find(c: Char): TrieNode? {
            return charMap[c]
        }
    }
}

// Brace Expansion
private class MockSolution2 {
    fun expand(s: String): Array<String> {
        val options = mutableListOf<List<Char>>()
        convertToGraph(s, options)
        val ans = HashSet<String>()
        dfs(0, StringBuilder(), options, ans)
        return ans.sorted().toTypedArray()
    }

    private fun dfs(i: Int, sb: StringBuilder, options: MutableList<List<Char>>, ans: HashSet<String>) {
        if (i == options.size) {
            ans.add(sb.toString())
            return
        }
        options[i].forEach {
            sb.append(it)
            dfs(i + 1, sb, options, ans)
            sb.deleteCharAt(sb.lastIndex)
        }
    }

    fun convertToGraph(s: String, options: MutableList<List<Char>>) {
        val stack = Stack<Char>()
        var isOption = false
        s.forEach {
            if (it == '{') {
                isOption = true
            } else if (it == '}') {
                isOption = false
                val optionList = mutableListOf<Char>()
                while (stack.isNotEmpty()) {
                    optionList.add(stack.pop())
                }
                options.add(optionList)
            } else if (it in 'a'..'z') {
                if (isOption) {
                    stack.add(it)
                } else {
                    options.add(listOf(it))
                }
            }
        }
    }
}

/**
 * Remove All Adjacent Duplicates In String
 */
private class MockSolution1 {
    fun removeDuplicates(s: String): String {
        val stack: Stack<Char> = Stack<Char>()
        s.forEach {
            if (stack.isNotEmpty() && stack.peek() == it) {
                stack.pop()
            } else {
                stack.add(it)
            }
        }
        val res = StringBuilder()
        while (stack.isNotEmpty()) {
            res.append(stack.pop())
        }
        return res.reverse().toString()
    }
}