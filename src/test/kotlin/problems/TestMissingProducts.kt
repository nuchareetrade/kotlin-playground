package problems

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class TestMissingProducts {
    @ParameterizedTest(name = "testMissingProducts {0}" )
    @MethodSource("getMissingProductTestSet")
    fun testMissingProducts(testSet: MissingProductsTestSet) {
        val missingProducts = MissingProducts().findMissingProducts(testSet.requestedProducts, testSet.deliveredProducts)
        Assertions.assertEquals(testSet.expectedMissingProducts, missingProducts)
    }

    data class MissingProductsTestSet(val requestedProducts: Array<Int>, val deliveredProducts: Array<Int>, val expectedMissingProducts: HashMap<Int,Int>)

    companion object {
        @JvmStatic
        fun getMissingProductTestSet(): List<MissingProductsTestSet> {
            return listOf(
                MissingProductsTestSet(arrayOf(11, 2, 4, 11, 11, 2, 3), arrayOf(2, 4, 2, 11) , hashMapOf(11 to 2,  3 to 1)),
                MissingProductsTestSet(arrayOf(1, 3, 5), arrayOf(1, 3, 5), hashMapOf()),
            )
        }

    }
}