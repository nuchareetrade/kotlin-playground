package problems

import java.util.*

class MissingProducts {
    fun findMissingProducts(requestedProducts: Array<Int>, deliveredProducts: Array<Int>): HashMap<Int, Int> {
        val productCounter = HashMap<Int, Int>()
        requestedProducts.map { product -> if (productCounter.containsKey(product)) productCounter[product] = productCounter[product]!! + 1 else productCounter[product] = 1 }
        deliveredProducts.map { product -> if (productCounter.containsKey(product)) productCounter[product] = productCounter[product]!! - 1 else productCounter[product] = -1 }
        return productCounter.filter { it.value > 0 } as HashMap<Int, Int>
    }
}