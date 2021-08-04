package leetcode.google

import kotlin.random.Random


interface Master {
    fun guess(word: String): Int
}

class GuessTheWord {

    fun findSecretWord(wordlist: Array<String>, master: Master) {
        if (wordlist.size <= 10) {
            wordlist.forEach {
                master.guess(it)
            }
            return
        }
        var population = wordlist.toList()
        for (test in 0 until 10) {
            val index = Random.nextInt(from = 0, until = population.size)
            val random = population[index]
            val c = master.guess(random)
            if (c == 6) {
                return
            }
            population = population.filter {
                random != it && match(random, it) == c
            }
        }
    }

    companion object {
        fun match(random: String, it: String): Int {
            var cnt = 0
            random.forEachIndexed { index, c ->
                if (c == it[index]) cnt++
            }
            return cnt
        }
    }
}

fun main() {
    val wordList = arrayOf(
        "gaxckt",
        "trlccr",
        "jxwhkz",
        "ycbfps",
        "peayuf",
        "yiejjw",
        "ldzccp",
        "nqsjoa",
        "qrjasy",
        "pcldos",
        "acrtag",
        "buyeia",
        "ubmtpj",
        "drtclz",
        "zqderp",
        "snywek",
        "caoztp",
        "ibpghw",
        "evtkhl",
        "bhpfla",
        "ymqhxk",
        "qkvipb",
        "tvmued",
        "rvbass",
        "axeasm",
        "qolsjg",
        "roswcb",
        "vdjgxx",
        "bugbyv",
        "zipjpc",
        "tamszl",
        "osdifo",
        "dvxlxm",
        "iwmyfb",
        "wmnwhe",
        "hslnop",
        "nkrfwn",
        "puvgve",
        "rqsqpq",
        "jwoswl",
        "tittgf",
        "evqsqe",
        "aishiv",
        "pmwovj",
        "sorbte",
        "hbaczn",
        "coifed",
        "hrctvp",
        "vkytbw",
        "dizcxz",
        "arabol",
        "uywurk",
        "ppywdo",
        "resfls",
        "tmoliy",
        "etriev",
        "oanvlx",
        "wcsnzy",
        "loufkw",
        "onnwcy",
        "novblw",
        "mtxgwe",
        "rgrdbt",
        "ckolob",
        "kxnflb",
        "phonmg",
        "egcdab",
        "cykndr",
        "lkzobv",
        "ifwmwp",
        "jqmbib",
        "mypnvf",
        "lnrgnj",
        "clijwa",
        "kiioqr",
        "syzebr",
        "rqsmhg",
        "sczjmz",
        "hsdjfp",
        "mjcgvm",
        "ajotcx",
        "olgnfv",
        "mjyjxj",
        "wzgbmg",
        "lpcnbj",
        "yjjlwn",
        "blrogv",
        "bdplzs",
        "oxblph",
        "twejel",
        "rupapy",
        "euwrrz",
        "apiqzu",
        "ydcroj",
        "ldvzgq",
        "zailgu",
        "xgqpsr",
        "wxdyho",
        "alrplq",
        "brklfk"
    )
    val guess = "hbaczn"
    GuessTheWord().findSecretWord(emptyArray(), object : Master {
        override fun guess(word: String): Int {
            return GuessTheWord.match(word, guess)
        }
    })
}

/**
 * "hbaczn"
["gaxckt","trlccr","jxwhkz","ycbfps","peayuf","yiejjw","ldzccp","nqsjoa","qrjasy","pcldos","acrtag","buyeia","ubmtpj","drtclz","zqderp","snywek","caoztp","ibpghw","evtkhl","bhpfla","ymqhxk","qkvipb","tvmued","rvbass","axeasm","qolsjg","roswcb","vdjgxx","bugbyv","zipjpc","tamszl","osdifo","dvxlxm","iwmyfb","wmnwhe","hslnop","nkrfwn","puvgve","rqsqpq","jwoswl","tittgf","evqsqe","aishiv","pmwovj","sorbte","hbaczn","coifed","hrctvp","vkytbw","dizcxz","arabol","uywurk","ppywdo","resfls","tmoliy","etriev","oanvlx","wcsnzy","loufkw","onnwcy","novblw","mtxgwe","rgrdbt","ckolob","kxnflb","phonmg","egcdab","cykndr","lkzobv","ifwmwp","jqmbib","mypnvf","lnrgnj","clijwa","kiioqr","syzebr","rqsmhg","sczjmz","hsdjfp","mjcgvm","ajotcx","olgnfv","mjyjxj","wzgbmg","lpcnbj","yjjlwn","blrogv","bdplzs","oxblph","twejel","rupapy","euwrrz","apiqzu","ydcroj","ldvzgq","zailgu","xgqpsr","wxdyho","alrplq","brklfk"]
10
 */