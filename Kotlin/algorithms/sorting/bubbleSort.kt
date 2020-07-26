/**
 * Implementation of Bubble Sort
 * @author Utkarsh Raj, utraj00114@gmail.com
 */
package com.raj.algorithms.sorting


fun main(args: Array<String>) {
    val arr: IntArray = intArrayOf(1, 2, 3, 10, -1, -5, 7, 0)
    bubbleSort(arr)
    println(arr.contentToString())
}

//optimised version of Bubble Sort (we will stop sorting when it has become sorted instead of running the loop completely)
fun bubbleSort(arr: IntArray) {
    do {
        var sorted: Boolean = true
        for (i in 1 until arr.size) {
            if (arr[i] < arr[i - 1]) {
                arr[i] = arr[i - 1].also { arr[i - 1] = arr[i] }
                sorted = false
            }


        }

    } while (!sorted)
}


