package leetcode.google

import java.util.*

/*
 *	// Definition for Employee.
 *	class Employee {
 *		var id:Int = 0
 *		var importance:Int = 0
 *		var subordinates:List<Int> = listOf()
 *	}
 */

class EmployeeImportance {
    fun getImportance(employees: List<Employee>, id: Int): Int {
        val employeeRefMap = hashMapOf<Int, Employee>()
        employees.forEach { employee ->
            employeeRefMap[employee.id] = employee
        }
        val queue: Queue<Int> = LinkedList<Int>()
        queue.add(id)
        var ans = 0
        while (queue.isNotEmpty()) {
            val cur = employeeRefMap[queue.poll()]
            if (cur != null) {
                ans += cur.importance
                cur.subordinates.forEach {
                    queue.offer(it)
                }
            }
        }
        return ans
    }

    data class Employee(
        var id: Int = 0,
        var importance: Int = 0,
        var subordinates: List<Int> = listOf(),
    )
}