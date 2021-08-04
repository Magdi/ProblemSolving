package leetcode.uber


class OptimalAccountBalancing2 {

    fun minTransfers(transactions: Array<IntArray>): Int {
        val balance = hashMapOf<Int, Int>()
        transactions.forEach { (from, to, price) ->
            var fromBalance = balance.getOrDefault(from, 0)
            var toBalance = balance.getOrDefault(to, 0)
            balance[from] = fromBalance + price
            balance[to] = toBalance - price
        }

        val balances = balance.values.toMutableList()
        return dfs(balances, 0)
    }

    private fun dfs(balance: MutableList<Int>, ind: Int): Int {
        if (ind == balance.size) {
            return 0
        }
        if (balance[ind] == 0) return dfs(balance, ind + 1)
        var transactions = Int.MAX_VALUE
        for (i in ind + 1 until balance.size) {
            if ((balance[i] * balance[ind] < 0)) {
                balance[i] += balance[ind]
                transactions = Math.min(transactions, 1 + dfs(balance, ind + 1))
                balance[i] -= balance[ind]

                if (balance[i] + balance[ind] == 0) {
                    break
                }
            }
        }

        return transactions
    }


}