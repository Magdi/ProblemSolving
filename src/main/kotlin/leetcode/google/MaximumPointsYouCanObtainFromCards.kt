package leetcode.google

/**
 * https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
 *
 * Sliding window
 */
class MaximumPointsYouCanObtainFromCards {

    //O (n) solution
    fun maxScore(cardPoints: IntArray, k: Int): Int {
        val removeWindow = cardPoints.size - k
        val totalSum = cardPoints.sum()
        var removedSum = 0
        var max = Int.MIN_VALUE
        for (i in 0 until removeWindow) {
            removedSum += cardPoints[i]
        }
        max = Math.max(totalSum - removedSum, max)

        for (i in removeWindow until cardPoints.size) {
            removedSum += cardPoints[i]
            removedSum -= cardPoints[i - removeWindow]
            max = Math.max(totalSum - removedSum, max)
        }
        return max
    }

    // O(k)
    fun maxScore2(cardPoints: IntArray, k: Int): Int {
        val n = cardPoints.size
        var forSum = 0
        var rearSum = 0
        for (i in 0 until k) {
            forSum += cardPoints[i]
        }
        var max = forSum
        for (i in 0 until k) {
            forSum -= cardPoints[k - i - 1]
            rearSum += cardPoints[n - i - 1]
            max = Math.max(forSum + rearSum, max)
        }
        return max
    }

}