package leetcode.google

import java.util.*

class CarFleetII {
    fun getCollisionTimes(cars: Array<IntArray>): DoubleArray {
        val carList = cars.map { (position, speed) -> Car(position, speed) }
        val carStack: Stack<Int> = Stack<Int>()

        val answer = DoubleArray(cars.size) { -1.0 }

        for (index in carList.lastIndex downTo 0) {
            val curCar = carList[index]
            while (carStack.isNotEmpty() && carList[carStack.peek()].Speed >= curCar.Speed) {
                carStack.pop()
            }
            while (carStack.isNotEmpty()) {
                val nextCar = carStack.peek()
                val collisionTime = getCollisionTime(curCar, carList[nextCar])
                if (compareDouble(collisionTime, answer[nextCar]) < 0 || answer[nextCar] < 0) {
                    answer[index] = collisionTime
                    break
                }
                carStack.pop()
            }
            carStack.push(index)
        }
        return answer
    }

    private fun getCollisionTime(car1: Car, car2: Car): Double {
        return (car2.position - car1.position).toDouble() / (car1.Speed - car2.Speed).toDouble()
    }

    private fun compareDouble(double: Double, double2: Double): Int {
        if (Math.abs(double - double2) <= .00001) return 0
        else if (double > double2) return 1
        else return -1
    }

    data class Car(val position: Int, val Speed: Int)
}