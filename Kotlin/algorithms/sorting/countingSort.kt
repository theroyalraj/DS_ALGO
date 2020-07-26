package com.raj.algorithms.sorting

fun main() {
    val arr: IntArray = intArrayOf(1, 21, -4, 60, 80, -30, 70, 60)
    val minValue = arr.min()!!
    val maxValue = arr.max()!!
    countingSort(arr, minValue, maxValue)
    println(arr.contentToString())
}

fun countingSort(arr: IntArray, minValue: Int?, maxValue: Int?) {
    val size = maxValue!! - minValue!! + 1
    val tempArray = IntArray(size)
    for (i in arr.indices) tempArray[arr[i] - minValue]++
    var l = 0
    for (i in tempArray.indices) {
        while (tempArray[i]-- > 0)
            arr[l++] = i + minValue
    }
    // println(message = "$minValue   $maxValue")

}

