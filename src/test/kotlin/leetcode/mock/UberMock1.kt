package leetcode.mock

import org.junit.Assert.*
import org.junit.Test
import kotlin.random.Random

class UberMock1 {
    @Test
    fun `test case 1`() {
        val rSet = RandomizedSet()
        assertFalse(rSet.remove(0))
        assertFalse(rSet.remove(0))
        assertTrue(rSet.insert(0))
        assertTrue(rSet.remove(0))
        assertTrue(rSet.insert(0))
    }
}

class RandomizedSet() {

    /** Initialize your data structure here. */
    private val location = HashMap<Int, Int>()
    private val elements = ArrayList<Int>()

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    fun insert(value: Int): Boolean {
        if (location.contains(value)) {
            return false
        }

        elements.add(value)
        location[value] = elements.size-1
        return true
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    fun remove(value: Int): Boolean {
        val toRemoveL = location.get(value) ?: return false

        //swap with last
        if (elements.size > 1) {
            val lastElement = elements.last()
            elements[toRemoveL] = lastElement
            location[lastElement] = toRemoveL
        }
        location.remove(value)
        elements.removeLast()
        return true
    }

    /** Get a random element from the set. */
    fun getRandom(): Int {
        val r = Random.nextInt(from = 0, until = elements.size)
        return elements[r]
    }

}


object MockInterview {
    fun singleNumber(nums: IntArray): Int {
        var res = 0
        nums.forEach {
            res = res xor it
        }
        return res
    }

    fun isValidSudoku(board: Array<CharArray>): Boolean {
        board.forEachIndexed { index, chars ->
            if (!validateRow(chars)) {
                println("r $index")
                return false
            }
        }
        (0 until board.first().size).forEach { col ->
            println("c $col")
            if (!validateCol(col, board)) return false
        }
        return validateBoxes(board)
    }

    private fun validateRow(row: CharArray): Boolean {
        val visited = HashSet<Char>()
        row.forEach { ch ->
            if (ch.isDigit()) {
                if (visited.contains(ch)) return false
                visited.add(ch)
            }

        }
        return true
    }

    private fun validateCol(col: Int, board: Array<CharArray>): Boolean {
        val visited = HashSet<Char>()
        (board.indices).forEach { r ->
            val ch = board[r][col]
            if (ch.isDigit()) {
                if (visited.contains(ch)) return false
                visited.add(ch)
            }

        }
        return true
    }

    private fun validateBoxes(board: Array<CharArray>): Boolean {
        for (i in 0 until 3) {
            for (j in 0 until 3) {
                val r = i * 3
                val c = j * 3
                if (!validateBox(r, c, board)) return false
            }
        }
        return true
    }

    private fun validateBox(row: Int, col: Int, board: Array<CharArray>): Boolean {
        val visited = HashSet<Char>()
        for (i in 0 until 3) {
            for (j in 0 until 3) {
                val ch = board[row + i][col + j]
                if (ch.isDigit()) {
                    if (visited.contains(ch)) return false
                    visited.add(ch)
                }
            }
        }
        return true
    }
}