package leetcode.google

import java.util.*
import kotlin.Comparator

class MaxValueOfEquation {
    //O (NLogN)
    fun findMaxValueOfEquation(points: Array<IntArray>, k: Int): Int {
        val queue = PriorityQueue<Point>()
        var max = Int.MIN_VALUE
        points.forEach { (x, y) ->
            while (queue.isNotEmpty() && x - queue.peek().position > k) {
                queue.poll()
            }
            if (queue.isNotEmpty()) {
                max = Math.max(max, x + y + queue.peek().diff)
            }
            queue.add(Point(y - x, x))
        }
        return max
    }

    class Point(val diff: Int, val position: Int) : Comparable<Point> {
        override fun compareTo(other: Point): Int {
            return other.diff.compareTo(diff)
        }
    }
}