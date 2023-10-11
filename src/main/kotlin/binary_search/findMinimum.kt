package binary_search

fun findMin(nums: IntArray): Int {
    var left = 0
    var right = nums.size - 1
    while (left < right) {
        val middle = (left + right) / 2
        if (nums[middle] > nums[right]) {
            left = middle + 1
        } else {
            right = middle
        }
    }
    return nums[left]
}