package leetcode.google

import org.junit.Test

import org.junit.Assert.*

class BikesAndWorkersTest {

    @Test
    fun assignBikes() {
        assertArrayEquals(
            intArrayOf(1, 0),
            BikesAndWorkers().assignBikes(
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