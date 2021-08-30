package leetcode.mock

import org.junit.Assert.*
import org.junit.Test
import java.util.*
import kotlin.collections.HashMap
import kotlin.math.floor

class MockInterview15Test {
    @Test
    fun `test case 1`() {
        assertEquals(2, MockInterview15.oddEvenJumps(intArrayOf(10, 13, 12, 14, 15)))
        assertEquals(3, MockInterview15.oddEvenJumps(intArrayOf(2, 3, 1, 1, 4)))
        assertEquals(3, MockInterview15.oddEvenJumps(intArrayOf(5, 1, 3, 4, 2)))
        assertEquals(6, MockInterview15.oddEvenJumps(intArrayOf(1, 2, 3, 2, 1, 4, 4, 5)))
    }
}

object MockInterview15 {
    fun calculateTime(keyboard: String, word: String): Int {
        val positionMap = HashMap<Char, Int>()
        keyboard.forEachIndexed { index, c -> positionMap[c] = index }
        var prev = 0
        var ans = 0
        for (c in word) {
            val p = positionMap[c]!!
            ans += Math.abs(prev - p)
            prev = p
        }
        return ans
    }

    private fun maxLevelSum(root: TreeNode?): Int {
        if (root == null) return 0
        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)
        var level = 1
        var max = Int.MIN_VALUE
        var maxLevel = 1
        while (queue.isNotEmpty()) {
            val levelSize = queue.size
            var sum = 0
            for (i in 0 until levelSize) {
                val cur = queue.poll()
                sum += cur.`val`
                cur.left?.let { queue.add(it) }
                cur.right?.let { queue.add(it) }
            }
            if (sum > max) {
                max = sum
                maxLevel = level
            }
            level++
        }
        return maxLevel
    }

    private class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }


    fun oddEvenJumps(arr: IntArray): Int {
        val bst = TreeSet<Node>()
        val lastLocation = HashMap<Int, Int>()
        lastLocation[arr.last()] = arr.lastIndex
        var cnt = 1
        bst.add(Node(arr.last(), arr.lastIndex, isEven = true, isOdd = true))
        for (i in arr.lastIndex - 1 downTo 0) {
            val cur = Node(arr[i], i)
            val nextBigger = bst.ceiling(cur)?.run {
                val location = lastLocation[value]!!
                bst.floor(Node(value, location))
            }
            var foundWay = false
            if (nextBigger != null) {
                if (nextBigger.index == arr.lastIndex) {
                    foundWay = true
                    cur.isOdd = true
                } else if (nextBigger.isEven) {
                    foundWay = true
                    cur.isOdd = true
                }
            }
            val nextLower = bst.floor(Node(cur.value, arr.size))?.run {
                val location = lastLocation[value]!!
                bst.floor(Node(value, location))
            }
            if (nextLower != null) {
                if (nextLower.index == arr.lastIndex) {
                    cur.isEven = true
                } else if (nextLower.isOdd) {
                    cur.isEven = true
                }
            }
            if (foundWay) cnt++
            bst.add(cur)
            lastLocation[cur.value] = i
        }
        return cnt
    }

    private data class Node(val value: Int, var index: Int, var isEven: Boolean = false, var isOdd: Boolean = false) :
        Comparable<Node> {
        override fun compareTo(other: Node): Int {
            if (value == other.value) {
                return index.compareTo(other.index)
            }
            return value.compareTo(other.value)
        }
    }
}