package leetcode.mock

import org.junit.Assert
import org.junit.Test
import java.util.*
import kotlin.Comparator
import kotlin.collections.HashMap
import kotlin.collections.HashSet

class MockInterview6Test {

    @Test
    fun `test case 1`() {
        val a = MockInterview6B.TreeNode(1)
        val b = MockInterview6B.TreeNode(2)
        val c = MockInterview6B.TreeNode(3)
        a.left = b
        b.right = c

        Assert.assertFalse(MockInterview6B().btreeGameWinningMove(a, 3, 2))
    }

    @Test
    fun `test case 2`() {
        Assert.assertEquals(
            6,
            MockInterview6C().assignBikes(
                workers = arrayOf(
                    intArrayOf(0, 0),
                    intArrayOf(2, 1),
                ),
                bikes = arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(3, 3),
                )
            )
        )
    }
}


class MockInterview6 {

    private val cache = HashMap<Int, Int>()

    fun numSquares(n: Int): Int {
        val perfectSquears = (100 downTo 1).map { it * it }
        return minNumbers(n, perfectSquears)
    }

    private fun minNumbers(n: Int, perfectSquears: List<Int>): Int {
        if (n == 0) return 0
        if (cache.containsKey(n)) return cache[n]!!
        var ans = 100000
        perfectSquears.forEach {
            if (it <= n) {
                ans = Math.min(ans, minNumbers(n - it, perfectSquears))
            }
        }
        cache[n] = ans
        return ans
    }
}

class MockInterview6B {
    fun btreeGameWinningMove(root: TreeNode?, n: Int, x: Int): Boolean {
        if (root == null) return false
        if (root.`val` == x) {
            val leftCnt = cnt(root.left)
            val right = n - leftCnt - 1
            return Math.abs(leftCnt - right) > 0
        } else {
            val newRoot = find(root, x)
            val nCnt = cnt(newRoot)
            val parentCnt = n - nCnt
            val left = cnt(newRoot!!.left)
            val right = nCnt - left - 1
            return parentCnt > nCnt || left > parentCnt + right || right > parentCnt + left
        }
    }

    private fun find(root: TreeNode?, x: Int): TreeNode? {
        if (root == null) return null
        if (root.`val` == x) return root
        val left = find(root.left, x)
        if (left != null) return left
        val right = find(root.right, x)
        if (right != null) return right
        return null
    }

    private fun cnt(root: TreeNode?): Int {
        if (root == null) return 0
        return 1 + cnt(root.left) + cnt(root.right)
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}

class MockInterview6C {
    fun assignBikes(workers: Array<IntArray>, bikes: Array<IntArray>): Int {
        val ans = 0
        val queue = PriorityQueue<State> { p0, p1 ->
            p0.totalDistance.compareTo(p1.totalDistance)
        }
        queue.add(State(0, 0, BitSet(bikes.size)))
        val cache = HashSet<Pair<Int, BitSet>>()
        while (queue.isNotEmpty()) {
            val cur = queue.poll()
            if (cur.index == workers.size) {
                return cur.totalDistance
            }
            if (cache.contains(Pair(cur.index, cur.doneBikes))) continue
            cache.add(Pair(cur.index, cur.doneBikes))
            for (j in bikes.indices) {
                if (!cur.doneBikes[j]) {
                    val next = cur.copy(
                        totalDistance = cur.totalDistance + calc(workers[cur.index], bikes[j]),
                        index = cur.index + 1,
                        doneBikes = cur.doneBikes.clone() as BitSet
                    )
                    next.doneBikes.set(j)
                    queue.add(next)
                }
            }
        }
        return ans
    }

    private fun calc(ints: IntArray, ints1: IntArray): Int {
        return Math.abs(ints[0] - ints1[0]) + Math.abs(ints[1] - ints1[1])
    }

    data class State(val totalDistance: Int = 0, val index: Int, val doneBikes: BitSet)

}