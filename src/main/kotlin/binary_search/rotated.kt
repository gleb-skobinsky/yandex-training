package binary_search

class RotatedArraySolution {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1

        while (left <= right) {
            val middle = left + (right - left) / 2

            if (nums[middle] == target) return middle

            if (nums[middle] <= nums[right]) {
                if (target > nums[middle] && target <= nums[right]) left = middle + 1
                else right = middle - 1
            } else {
                if (target < nums[middle] && target >= nums[left]) right = middle - 1
                else left = middle + 1
            }
        }
        return -1
    }
}