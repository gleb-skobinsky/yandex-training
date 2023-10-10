package binary_search

fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    val m = matrix.size
    val n = matrix[0].size

    var left = 0
    var right = m * n - 1

    while (left <= right) {
        val mid = left + (right - left) / 2
        val num = matrix[mid / n][mid % n]
        when {
            num > target -> right = mid - 1
            num < target -> left = mid + 1
            else -> return true
        }
    }

    return false
}
