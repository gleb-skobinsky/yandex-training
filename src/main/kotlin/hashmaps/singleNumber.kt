package hashmaps

fun singleNumber(nums: IntArray): Int {
    val counts = mutableMapOf<Int, Int>()
    for (num in nums) {
        if (counts[num] == null) {
            counts[num] = 1
        } else {
            counts[num] = 2
        }
    }
    for (num in nums) {
        if (counts[num] == 1) return num
    }
    return 0
}