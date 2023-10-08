package binary_search

class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1

        while (left <= right) {
            // находим середину массива
            var mid = left + ((right - left) / 2)
            // если число в середине массива - искомое, возвращаем
            if (nums[mid] == target) return mid
            // если число в середине массива меньше искомого, продолжаем поиск в первой половине
            if (nums[mid] > target) right = mid - 1
            // если число в середине массива больше искомого, продолжаем поиск во второй половине
            if (nums[mid] < target) left = mid + 1
        }
        return -1
    }
}