package leetcode.google

class CarFleet {

    // O(n log n)
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        val cars = position.mapIndexed { index, i ->
            val timeToTarget: Double = (target - position[index]) / speed[index].toDouble()
            Car(position[index], speed[index], timeToTarget)
        }.sortedBy { it.pos }

        var fleetsCnt = 1
        var last = cars.last().timeToTarget
        for (i in cars.lastIndex - 1 downTo 0) {
            if (cars[i].timeToTarget > last) {
                fleetsCnt++
                last = cars[i].timeToTarget
            }
        }
        return fleetsCnt
    }


    data class Car(val pos: Int, val speed: Int, var timeToTarget: Double)
}