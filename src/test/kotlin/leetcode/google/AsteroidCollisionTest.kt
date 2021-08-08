package leetcode.google

import org.junit.Test

import org.junit.Assert.*

class AsteroidCollisionTest {

    @Test
    fun `test case 1`() {
        val ans = AsteroidCollision().asteroidCollision(intArrayOf(5, 10, -5))
        assertArrayEquals(intArrayOf(5, 10), ans)
    }

    @Test
    fun `test case 2`() {
        val ans = AsteroidCollision().asteroidCollision(intArrayOf(8, -8))
        assertArrayEquals(intArrayOf(), ans)
    }

    @Test
    fun `test case 3`() {
        val ans = AsteroidCollision().asteroidCollision(intArrayOf(10, 2, -5))
        assertArrayEquals(intArrayOf(10), ans)
    }

    @Test
    fun `test case 4`() {
        val ans = AsteroidCollision().asteroidCollision(intArrayOf(-2, -1, 1, 2))
        assertArrayEquals(intArrayOf(-2, -1, 1, 2), ans)
    }

    @Test
    fun `test case 6`() {
        val ans = AsteroidCollision().asteroidCollision(intArrayOf(-2, -2, 1, -1))
        assertArrayEquals(intArrayOf(-2, -2), ans)
    }

    @Test
    fun `test case 7`() {
        val ans = AsteroidCollision().asteroidCollision(intArrayOf(-2, 2, -1, -2))
        assertArrayEquals(intArrayOf(-2), ans)
    }


    @Test
    fun `test case 9`() {
        val ans = AsteroidCollision().asteroidCollision(intArrayOf(1, 1, 1, 1, -1, -1, -1, -1))
        assertArrayEquals(intArrayOf(), ans)
    }


}