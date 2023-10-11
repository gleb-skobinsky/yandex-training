package hashmaps

import java.util.*


fun fourSum(nums: IntArray, target: Int): List<MutableList<Int>> {
    Arrays.sort(nums)
    return kSum(nums, target.toLong(), 0, 4)
}

fun kSum(nums: IntArray, target: Long, start: Int, k: Int): List<MutableList<Int>> {
    val res: MutableList<MutableList<Int>> = ArrayList()

    // If we have run out of numbers to add, return res.
    if (start == nums.size) {
        return res
    }

    // There are k remaining values to add to the sum. The
    // average of these values is at least target / k.
    val averageValue = target / k

    // We cannot obtain a sum of target if the smallest value
    // in nums is greater than target / k or if the largest
    // value in nums is smaller than target / k.
    if (nums[start] > averageValue || averageValue > nums[nums.size - 1]) {
        return res
    }
    if (k == 2) {
        return twoSum(nums, target, start)
    }
    for (i in start until nums.size) {
        if (i == start || nums[i - 1] != nums[i]) {
            for (subset in kSum(nums, target - nums[i], i + 1, k - 1)) {
                res.add(mutableListOf(nums[i]))
                res[res.size - 1].addAll(subset)
            }
        }
    }
    return res
}

fun twoSum(nums: IntArray, target: Long, start: Int): List<MutableList<Int>> {
    val res: MutableList<MutableList<Int>> = ArrayList()
    val s: MutableSet<Long> = HashSet()
    for (i in start until nums.size) {
        if (res.isEmpty() || res[res.size - 1][1] != nums[i]) {
            if (s.contains(target - nums[i])) {
                res.add(mutableListOf(target.toInt() - nums[i], nums[i]))
            }
        }
        s.add(nums[i].toLong())
    }
    return res
}
