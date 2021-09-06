package leetcode.facebook

/**
 * https://leetcode.com/problems/robot-room-cleaner/
 */
class Problem489 {
    private val di = listOf(1, -1, 0, 0)
    private val dj = listOf(0, 0, 1, -1)

    fun cleanRoom(robot: Robot) {
        dfs(0,0,0, HashSet(), robot)
    }

    fun dfs(x: Int, y: Int, d: Int, visited: HashSet<Pair<Int, Int>>, robot: Robot) {
        println("$x $y")
        visited.add(Pair(x, y))
        robot.clean()
        for (k in 0 until 4) {
            val newD = (d + k) % 4
            val ni = (d + di[newD])
            val nj = (d + dj[newD])
            if (!visited.contains(Pair(ni, nj)) && robot.move()) {
                dfs(ni, nj, newD, visited, robot)
                robot.goBack()
            }
            robot.turnRight()
        }
    }

    fun Robot.goBack() {
        turnRight()
        turnRight()
        move()
        turnRight()
        turnRight()
    }
}


// This is the Robot's API interface.
// You should not implement it, or speculate about its implementation
interface Robot {
    // Returns true if the cell in front is open and robot moves into the cell.
    // Returns false if the cell in front is blocked and robot stays in the current cell.
    fun move(): Boolean

    // Robot will stay in the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    fun turnLeft()
    fun turnRight()

    // Clean the current cell.
    fun clean()
}
