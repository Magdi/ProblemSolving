package leetcode.mock

import org.junit.Assert
import org.junit.Test
import java.util.*
import kotlin.Comparator
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

class MockInterview10Test {
    @Test
    fun `test case 1`() {
        Assert.assertEquals(3, MockInterview10.findSpecialInteger(intArrayOf(1, 2, 3, 3)))
        Assert.assertEquals(6, MockInterview10.findSpecialInteger(intArrayOf(1, 2, 2, 6, 6, 6, 6, 7, 10)))
    }


    @Test
    fun `test case 2`() {
//        Assert.assertEquals(
//            7, MockInterview10.kthSmallest(
//                arrayOf(
//                    intArrayOf(1, 3, 11),
//                    intArrayOf(2, 4, 6),
//                ),
//                5
//            )
//        )
        Assert.assertEquals(
            17, MockInterview10.kthSmallest(
                arrayOf(
                    intArrayOf(1, 3, 11),
                    intArrayOf(2, 4, 6),
                ),
                9
            )
        )
    }
}

private object MockInterview10 {
    fun findSpecialInteger(arr: IntArray): Int {
        var cnt = 1
        for (i in 1..arr.lastIndex) {
            if (arr[i] != arr[i - 1]) {
                cnt = 0
            }
            cnt++
            if (cnt * 4 > arr.size) {
                return arr[i]
            }
        }
        return arr.last()
    }

    fun getAllElements(root1: TreeNode?, root2: TreeNode?): List<Int> {
        val sortedList1 = ArrayList<Int>()
        normalize(root1, sortedList1)
        val sortedList2 = ArrayList<Int>()
        normalize(root2, sortedList2)
        var a = 0
        var b = 0
        val result = ArrayList<Int>()
        while (a < sortedList1.size || b < sortedList2.size) {
            if (a == sortedList1.size) {
                result.add(sortedList2[b++])
            } else if (b == sortedList2.size) {
                result.add(sortedList1[a++])
            } else {
                if (sortedList1[a] < sortedList2[b]) {
                    result.add(sortedList1[a++])
                } else {
                    result.add(sortedList2[b++])
                }
            }
        }
        return result
    }

    private fun normalize(root: TreeNode?, sortedList: ArrayList<Int>) {
        if (root == null) return
        root.left?.run { normalize(this, sortedList) }
        sortedList.add(root.`val`)
        root.right?.run { normalize(this, sortedList) }
    }

    private class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }


    fun kthSmallest(mat: Array<IntArray>, k: Int): Int {
        var pQueue = PriorityQueue<Int>(Collections.reverseOrder())
        pQueue.add(0)
        mat.forEach { row: IntArray ->
            val next = PriorityQueue<Int>(Collections.reverseOrder())
            pQueue.forEach { prevSum ->
                row.forEach { item ->
                    next.add(prevSum + item)
                    if (next.size > k) next.poll()
                }
            }
            pQueue = next
        }
        return pQueue.poll()
    }

    data class Node(val row: List<Int>, val sum: Int) : Comparable<Node> {
        override fun compareTo(other: Node): Int {
            return sum.compareTo(other.sum)
        }
    }
}
