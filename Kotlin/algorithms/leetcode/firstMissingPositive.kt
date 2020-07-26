/**
 * this code is implementation of the question ArrayMex or first Missing positive number in an Array
 * The testing data has been tested on Leetcode
 * https://leetcode.com/problems/first-missing-positive/
 *
 * @author Utkarsh Raj, utraj00114@gmail.com
 */

package com.raj.algorithms.leetcode

fun main(args: Array<String>) {
    val nums = intArrayOf()
    println("Array is ${nums.contentToString()}")
    println("first positive missing number in O(n) time complexity and O(n) using counting technique ${arrayMex(nums)}")
    println("first positive missing number in O(n) time complexity and O(1) ${firstMissingPositive(nums)}")
}

// in-place shifting to get min positive
fun firstMissingPositive(nums: IntArray): Int {
    val n: Int = nums.size
    var i: Int = 0
    while (i < n) {
        if (nums[i] == i + 1 || nums[i] <= 0 || nums[i] > n) i++
        else if (nums[i] != nums[nums[i] - 1])
            nums[i] = nums[nums[i] - 1].also { nums[nums[i] - 1] = nums[i] }
        else i++
    }
    i = 0
    while (i < n && nums[i] == i + 1) i++
    return i + 1
}

fun arrayMex(nums: IntArray): Int {

    val count = IntArray(nums.size + 1)
    for (i in nums) {
        if (i > 0 && i <= nums.size) {
            count[i]++
        }
    }
    for (i in 1 until count.size) if (count[i] == 0) return i

    return 1
}
