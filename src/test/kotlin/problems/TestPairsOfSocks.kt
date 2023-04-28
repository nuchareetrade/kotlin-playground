package problems

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class TestPairsOfSocks {
    @ParameterizedTest(name = "testPairsOfSocks {0}" )
    @MethodSource("testSetProvider")
    fun testPairsOfSocks(testSet: TestSet) {
        val socks = testSet.inputArray
        val pairs = problems.PairsOfSocksProblem().countPairsOfSocks(socks)
        assertEquals(testSet.expectedPairCount, pairs)
    }

    data class TestSet(val inputArray: Array<Int>, val expectedPairCount: Int)

    companion object {
        @JvmStatic
        fun testSetProvider(): List<TestSet> {
            return listOf(
                TestSet(arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9), 0),
                TestSet(arrayOf(4, 7, 3, 7, 4, 1, 8, 4), 2),
                TestSet(arrayOf(1, 2, 1, 2, 1, 3, 2, 3, 3, 3, 4, 4, 4), 5),
                TestSet(arrayOf(), 0),
                TestSet(arrayOf(1, 2), 0),
            )
        }

    }
}