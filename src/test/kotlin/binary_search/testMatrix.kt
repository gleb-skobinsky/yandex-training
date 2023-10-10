package binary_search

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TestMatrix {
    @Test
    fun testCase1() {
        val output = searchMatrix(
            arrayOf(
                intArrayOf(1,3,5,7),
                intArrayOf(10,11,16,20),
                intArrayOf(23,30,34,60)
            ),
            3
        )
        assertEquals(output, true)
    }
}