package leetcode.google

import java.util.*

class Problem871 {

    fun minRefuelStops(target: Int, startFuel: Int, stations: Array<IntArray>): Int {
        var rem = startFuel
        var prePosition = 0
        var ans = 0
        val queue = PriorityQueue<Int>(Collections.reverseOrder())
        stations.forEach { (position, fuel) ->
            rem -= (position - prePosition)
            while (queue.isNotEmpty() && rem < 0) {
                rem += queue.poll()
                ans++
            }
            if (rem < 0) return -1
            queue.offer(fuel)
            prePosition = position
        }

        rem -= target - prePosition
        while (queue.isNotEmpty() && rem < 0) {
            rem += queue.poll()
            ans++
        }
        return if (rem < 0) -1
        else ans
    }
}