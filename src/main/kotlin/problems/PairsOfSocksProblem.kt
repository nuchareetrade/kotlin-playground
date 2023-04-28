package problems

class PairsOfSocksProblem {

    fun countPairsOfSocks(socks: Array<Int>): Int {
        val pairCounter = HashMap<Int, Int>();
        socks.map { sock -> if (pairCounter.containsKey(sock)) pairCounter[sock] = pairCounter[sock]!! + 1 else pairCounter[sock] = 1 }
        return pairCounter.map { countCompletePair(it.value) }.sum()
    }

    private fun
            countCompletePair(socks: Int): Int {
        return socks / 2
    }
}