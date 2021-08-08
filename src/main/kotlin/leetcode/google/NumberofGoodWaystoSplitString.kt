package leetcode.google

class NumberofGoodWaystoSplitString {

    fun numSplits(s: String): Int {
        if (s.length <= 1) return 0
        val frontUniqueCount = getUniqueCnt(s)
        val rearUniqueCount = getUniqueCnt(s.reversed()).reversed()
        var res = 0
        for (i in 1 until s.length) {
            if (frontUniqueCount[i-1] == rearUniqueCount[i]) {
                res++
            }
        }
        return res
    }

    private fun getUniqueCnt(s: String): List<Int> {
        val unique = mutableSetOf<Char>()
        val results = mutableListOf<Int>()
        s.forEach {
            unique.add(it)
            results.add(unique.size)
        }
        return results
    }
}