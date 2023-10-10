package hashmaps

fun twoSum(nums: IntArray, target: Int): IntArray {
    val counts = HashMap<Int, Int>()
    for (i in nums.indices) {
        counts[nums[i]] = i
    }
    for (i in nums.indices) {
        val num = nums[i]
        val compliment = target - num
        val inMap = counts[compliment]
        if (inMap != null && inMap != i) {
            return intArrayOf(i, inMap)
        }
    }
    return intArrayOf()
}