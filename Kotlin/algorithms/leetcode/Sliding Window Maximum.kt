/**
 * This file contain an implementation of the maximum sliding window problem. This code has been
 * tested against the judge data on:
 *
 * <p>https://leetcode.com/problems/sliding-window-maximum/
 *
 * @author Utkarsh Raj, utraj00114@gmail.com
 */

package com.raj.algorithms.leetcode

fun main() {

//    val n:Int= readLine()!!.toInt()
//    val k:Int= readLine()!!.toInt()
//    val arr=IntArray(n)
//    repeat(n){
//        arr[it]= readLine()!!.toInt()
//
    val n: Int = 8;
    val k: Int = 3;
    val arr = intArrayOf(1, 3, -1, -3, 5, 3, 6, 7)
    val out: IntArray = maxSlidingWindow(arr, k)
    println(out.contentToString())

}

fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
    val n = nums.size;
    var l = 0
    val arr = IntArray(n - k + 1)
    var dq: ArrayDeque<Int> = ArrayDeque<Int>()
    for (i in 0 until k) {
        while (dq.isNotEmpty() && (nums[i] >= nums[dq.last()]))
            dq.removeLast();
        dq.addLast(i)
    }
    for (i in k until n) {
        arr[l++] = nums[dq.first()];
        while (!dq.isEmpty() && (dq.first() <= i - k))
            dq.removeFirst();
        while (!dq.isEmpty() && (nums[i] >= nums[dq.last()]))
            dq.removeLast();
        dq.addLast(i);
    }
    arr[l] = nums[dq.first()];
    return arr;

}
