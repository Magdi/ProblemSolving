package leetcode


class OptimalAccountBalancing {

    fun minTransfers(transactions: Array<IntArray>): Int {
        val balance = hashMapOf<Int, Int>()
        transactions.forEach { (from, to, price) ->
            var fromBalance = balance.getOrDefault(from, 0)
            var toBalance = balance.getOrDefault(to, 0)
            balance[from] = fromBalance + price
            balance[to] = toBalance - price
        }

        val balances = balance.values.toList()
        val n = balance.size

        val groupSum = mutableListOf<Group>()
        for (group in 0 until (1 shl n)) { // create all groups
            var sum = 0
            var cnt = 0
            for (i in 0 until n) {
                if (group and (1 shl i) != 0) {
                    cnt++
                    sum += balances[i]
                }
            }
            if (sum == 0 && cnt > 0) {
                groupSum.add(Group(group, cnt))
            }
        }

        val dp = hashMapOf<Pair<Int, Int>, Int>()
        return minTransactions(groupSum, 0, 0, n, dp)
    }

    private fun minTransactions(
        groups: List<Group>,
        ind: Int,
        mask: Int,
        n: Int,
        dp: HashMap<Pair<Int, Int>, Int>
    ): Int {
        val key = Pair(ind, mask)
        if (countBits(mask) == n) {
            dp[key] = 0
            return 0
        }
        if (ind == groups.size) {
            return Int.MAX_VALUE
        }
        dp[key]?.run { return this }
        return Math.min(
            minTransactions(groups, ind + 1, mask, n, dp),
            minTransactions(groups, ind + 1, mask or groups[ind].mask, n, dp) + (groups[ind].count - 1)
        ).also {
            dp[key] = it
        }
    }

    private fun countBits(num: Int): Int {
        var r = num
        var cnt = 0
        while (r > 0) {
            cnt++
            r = r and (r - 1)
        }
        return cnt
    }

    data class Group(
        val mask: Int,
        val count: Int,
    )

}