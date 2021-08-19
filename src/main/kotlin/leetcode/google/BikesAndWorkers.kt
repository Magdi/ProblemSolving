package leetcode.google

import java.util.*
import kotlin.Comparator
import kotlin.collections.HashMap
import kotlin.collections.HashSet

class BikesAndWorkers {
    fun assignBikes(workers: Array<IntArray>, bikes: Array<IntArray>): IntArray {
        val distance = PriorityQueue<Distance> { p0, p1 ->
            if (p0.distance != p1.distance) {
                p0.distance.compareTo(p1.distance)
            } else if (p1.workerIndex != p0.workerIndex) {
                p0.workerIndex.compareTo(p1.workerIndex)
            } else {
                p0.bikeIndex.compareTo(p1.bikeIndex)
            }
        }
        workers.forEachIndexed { wIndex, (wx, wy) ->
            bikes.forEachIndexed { bIndex, (bx, by) ->
                val dist = Math.abs(wx - bx) + Math.abs(wy - by)
                distance.offer(Distance(dist, bIndex, wIndex))
            }
        }
        val assignedWorkers = HashSet<Int>()
        val assignedBikes = HashSet<Int>()
        val ans = IntArray(workers.size)
        while (assignedWorkers.size < workers.size) {
            val cur = distance.poll()
            if (!assignedBikes.contains(cur.bikeIndex) && !assignedWorkers.contains(cur.workerIndex)) {
                ans[cur.workerIndex] = cur.bikeIndex
                assignedBikes.add(cur.bikeIndex)
                assignedWorkers.add(cur.workerIndex)
            }
        }

        return ans
    }

    private data class Distance(val distance: Int, val bikeIndex: Int, val workerIndex: Int)
}