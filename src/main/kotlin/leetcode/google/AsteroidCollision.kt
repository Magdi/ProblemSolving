package leetcode.google

import java.util.*


class AsteroidCollision {
    fun asteroidCollision(asteroids: IntArray): IntArray {
        val stack = Stack<Int>()
        asteroids.forEach { asteroid ->
            var survived = true
            while (stack.isNotEmpty() && asteroid < 0 && 0 < stack.peek()) {
                if (stack.peek() < -asteroid) {
                    stack.pop()
                    continue
                } else if (stack.peek() == -asteroid) {
                    stack.pop()
                }
                survived = false
                break
            }
            if (survived) {
                stack.push(asteroid)
            }
        }

        return stack.toList().toIntArray()
    }
}