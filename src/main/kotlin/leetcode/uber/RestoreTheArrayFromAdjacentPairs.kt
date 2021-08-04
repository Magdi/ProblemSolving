package leetcode.uber

class RestoreTheArrayFromAdjacentPairs {
    fun restoreArray(adjacentPairs: Array<IntArray>): IntArray {
        if (adjacentPairs.size == 1) {
            return adjacentPairs[0]
        }
        val results = IntArray(adjacentPairs.size + 1)
        val numbersAdj = hashMapOf<Int, List<Int>>()
        adjacentPairs.forEach { (x, y) ->
            addAdj(numbersAdj, x, y)
            addAdj(numbersAdj, y, x)
        }
        var first: Int = 0
        numbersAdj.forEach { (num, list) ->
            if (list.size == 1) {
                first = num
                return@forEach
            }
        }

        results[0] = first
        results[1] = numbersAdj[first]!![0]

        for (index in 2 until numbersAdj.size) {
            val parent = results[index - 2]
            val cur = numbersAdj[results[index - 1]]!!.first { it != parent }
            results[index] = cur
        }

        return results
    }

    private fun addAdj(
        numbersAdj: HashMap<Int, List<Int>>,
        x: Int,
        y: Int
    ) {
        val list = numbersAdj.getOrDefault(x, emptyList()).toMutableList()
        list.add(y)
        numbersAdj[x] = list
    }
}