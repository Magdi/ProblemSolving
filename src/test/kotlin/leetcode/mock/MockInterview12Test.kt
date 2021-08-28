package leetcode.mock

import org.junit.Assert
import org.junit.Test


class MockInterview12Test {
    @Test
    fun `test case 1`() {
        Assert.assertEquals(
            105.0, MockInterview12.mincostToHireWorkers(
                intArrayOf(10, 20, 5),
                intArrayOf(70, 50, 30),
                2
            ), .000001
        )
    }
}

object MockInterview12 {
    fun isToeplitzMatrix(matrix: Array<IntArray>): Boolean {
        val n = matrix.size
        val m = matrix.first().size
        for (i in 0 until m) {
            if (!test(0, i, n, m, matrix)) return false
        }
        for (i in 0 until n) {
            if (!test(i, 0, n, m, matrix)) return false
        }
        return true
    }

    private fun test(x: Int, y: Int, n: Int, m: Int, matrix: Array<IntArray>): Boolean {
        var x = x
        var y = y
        val set = HashSet<Int>()
        while (x < n && y < m) {
            set.add(matrix[x][y])
            x++
            y++
        }
        return set.size == 1
    }

    fun getHint(secret: String, guess: String): String {
        val bulls = HashSet<Int>()
        val counters = IntArray(10) { 0 }
        for (i in secret.indices) {
            if (secret[i] == guess[i]) {
                bulls.add(i)
            } else {
                counters[secret[i] - '0']++
            }
        }
        var cows = 0
        for (i in guess.indices) {
            if (!bulls.contains(i) && counters[guess[i] - '0'] > 0) {
                counters[guess[i] - '0']--
                cows++
            }
        }

        return "${bulls.size}A${cows}B"
    }

    fun mincostToHireWorkers(quality: IntArray, wage: IntArray, k: Int): Double {
        val workers = quality.mapIndexed { index, _ ->
            Worker(quality[index].toDouble(), wage[index].toDouble())
        }
        val cache = HashMap<State, Double>()
        return (0..wage.lastIndex).mapNotNull { index ->
            val x = calc(0, k - 1, index, workers, cache) + wage[index]
            x
        }.min()!!
    }


    private const val MAX_VALUE = (10000.0 * 10000.0) + 100
    private fun calc(
        ind: Int,
        rem: Int,
        baseIndex: Int,
        workers: List<Worker>,
        cache: HashMap<State, Double>
    ): Double {
        if (rem <= 0) return 0.0
        if (ind == workers.size) return MAX_VALUE
        if (ind == baseIndex) return calc(ind + 1, rem, baseIndex, workers, cache)
        val state = State(ind, rem, baseIndex)
        if (cache.containsKey(state)) return cache[state]!!


        val cost = (workers[ind].q / workers[baseIndex].q) * workers[baseIndex].w
        val take = if (cost > workers[ind].w) {
            calc(ind + 1, rem - 1, baseIndex, workers, cache) + cost
        } else MAX_VALUE
        val skip = calc(ind + 1, rem, baseIndex, workers, cache)
        val min = Math.min(take, skip)
        cache[state] = min
        return min
    }

    private data class Worker(val q: Double, val w: Double)
    private data class State(val ind: Int, val rem: Int, val baseIndex: Int)


}