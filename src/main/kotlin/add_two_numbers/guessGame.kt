package add_two_numbers

open class GuessGame {
    private val answer = 6
    fun guess(num: Int): Int {
        return when {
            num < answer -> 1
            num > answer -> -1
            else -> 0
        }
    }

    open fun guessNumber(n: Int): Int {
        return 0
    }
}

class Solution : GuessGame() {
    override fun guessNumber(n: Int): Int {
        var left = 1
        var right = n
        var mid = 0
        while (left <= right) {
            mid = left + (right - left) / 2
            when (guess(mid)) {
                0 -> break
                -1 -> right = mid - 1
                else -> left = mid + 1
            }
        }
        return mid
    }
}