package leetcode.mock

import leetcode.mock.MockInterview6B.TreeNode
import org.junit.Assert
import org.junit.Test
import java.util.*
import kotlin.collections.HashSet

class UberMock2Test {
    @Test
    fun `test case 1`() {
        Assert.assertEquals(
            2, UberMock2B.regionsBySlashes(
                arrayOf(
                    " /",
                    "/ "
                )
            )
        )
    }

    @Test
    fun `test case c`() {
        Assert.assertTrue(UberMock2C.judgePoint24(intArrayOf(4, 1, 8, 7)))
    }

    @Test
    fun `test case d`() {
        Assert.assertArrayEquals(
            intArrayOf(3, 4), MockInterview22().searchRange(
                intArrayOf(5, 7, 7, 8, 8, 10), 8
            )
        )
    }
}

object UberMock2 {
    var min1 = 0
    var ans = Long.MAX_VALUE

    fun dfs(root: TreeNode?) {
        if (root != null) {
            if (min1 < root.`val` && root.`val` < ans) {
                ans = root.`val`.toLong()
            } else if (min1 == root.`val`) {
                dfs(root.left)
                dfs(root.right)
            }
        }
    }

    fun findSecondMinimumValue(root: TreeNode): Int {
        min1 = root.`val`
        dfs(root)
        return if (ans < Long.MAX_VALUE) ans.toInt() else -1
    }
}

object UberMock2B {
    fun regionsBySlashes(grid: Array<String>): Int {
        val visited = HashSet<Part>()
        var groups = 0
        val n = grid.size
        val m = grid.first().length
        for (i in 0 until n) {
            for (j in 0 until m) {
                for (k in 0 until 4) {
                    val p = Part(i, j, k)
                    if (!visited.contains(p)) {
                        groups++
                        dfs(p, grid, visited)
                    }
                }
            }
        }
        return groups
    }

    private fun dfs(p: Part, grid: Array<String>, visited: HashSet<Part>) {
        if (p.row in grid.indices && p.col in grid.first().indices && !visited.contains(p)) {
            visited.add(p)
            when (p.type) {
                1 -> {
                    dfs(Part(p.row, p.col + 1, 3), grid, visited)
                }
                3 -> {
                    dfs(Part(p.row, p.col - 1, 1), grid, visited)
                }
                2 -> {
                    dfs(Part(p.row + 1, p.col, 0), grid, visited)
                }
                0 -> {
                    dfs(Part(p.row - 1, p.col, 2), grid, visited)
                }
            }
            if (grid[p.row][p.col] == '\\') {
                dfs(Part(p.row, p.col, p.type xor 1), grid, visited)
            } else if (grid[p.row][p.col] == '/') {
                dfs(Part(p.row, p.col, p.type xor 3), grid, visited)
            } else {
                for (k in 0 until 4) {
                    dfs(p.copy(type = k), grid, visited)
                }
            }
        }
    }

    private data class Part(val row: Int, val col: Int, val type: Int)
}

object UberMock2C {
    fun judgePoint24(cards: IntArray): Boolean {
        cards.sort()
        val ops = listOf('-', '+', '*', '/')
        val queue: Queue<List<Double>> = LinkedList()
        queue.add(cards.map { it.toDouble() })
        while (queue.isNotEmpty()) {
            val cur = queue.poll()
            if (cur.size == 1) {
                if (Math.abs(cur.first() - 24) < 0.00001) return true
                else continue
            }
            for (i in cur.indices) {
                for (j in cur.indices) {
                    if (i == j) continue
                    ops.forEach { op ->
                        val new = when (op) {
                            '-' -> cur[i] - cur[j]
                            '+' -> cur[i] + cur[j]
                            '*' -> cur[i] * cur[j]
                            '/' -> cur[i] / cur[j]
                            else -> 1.0
                        }
                        var newList = cur.filterIndexed { index, _ -> index != i && index != j }.toMutableList()
                        newList.add(new)
                        queue.add(newList)
                    }
                }
            }
        }
        return false
    }


}

class MockInterview22 {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        return intArrayOf(lowerBound(nums, target), upperBound(nums, target))
    }

    private fun lowerBound(nums: IntArray, target: Int): Int {
        var start = 0
        var end = nums.size - 1
        while (start < end) {
            val mid = (start + end) / 2
            if (nums[mid] >= target) {
                end = mid - 1
            } else {
                start = mid + 1
            }
        }
        if (nums[start] != target) return -1
        else return start
    }

    private fun upperBound(nums: IntArray, target: Int): Int {
        var start = 0
        var end = nums.size - 1
        while (start < end) {
            val mid = ((start + end) / 2) + 1
            if (nums[mid] > target) {
                end = mid - 1
            } else {
                start = mid
            }
        }
        if (nums[start] != target) return -1
        else return start
    }
}