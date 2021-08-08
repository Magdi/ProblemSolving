package leetcode.google

import org.junit.Test

import org.junit.Assert.*

class EmployeeImportanceTest {

    @Test
    fun `test case 1`() {
        val employees = listOf<EmployeeImportance.Employee>(
            EmployeeImportance.Employee(1, 5, listOf(2,3)),
            EmployeeImportance.Employee(2, 3),
            EmployeeImportance.Employee(3, 3),
        )

        assertEquals(11, EmployeeImportance().getImportance(employees, 1))
    }

    @Test
    fun `test case 2`() {
        val employees = listOf<EmployeeImportance.Employee>(
            EmployeeImportance.Employee(1, 5, listOf(2,3)),
            EmployeeImportance.Employee(2, 3),
            EmployeeImportance.Employee(3, 3),
        )

        assertEquals(3, EmployeeImportance().getImportance(employees, 3))
    }
}