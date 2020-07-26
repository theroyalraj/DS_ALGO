package com.raj.algorithms.problems.recursion

import java.util.*

/**
 * this problem is from https://practice.geeksforgeeks.org/problems/tower-of-hanoi/0
 *
 * @author Utkarsh Raj, utraj00114@gmail.com
 */
// { Driver Code Starts
// Initial Template for Java
/*package whatever //do not write package name here */
internal object TowerOfHanoi {
    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        var t = sc.nextInt()
        while (t-- > 0) {
            val obj = Hanoi()
            var n: Int = sc.nextInt()
            println(obj.toh(n, 1, 3, 2))
        }
    }
} // avoid space at the starting of the string in "move disk....."

internal class Hanoi {
    // long count=0;
    fun toh(N: Int, from: Int, to: Int, aux: Int): Long {
        var count: Long = 0
        if (N >= 1) {
            count += toh(N - 1, from, aux, to)
            count++
            println("move disk $N from rod $from to rod $to")
            count += toh(N - 1, aux, to, from)
            return count
        }
        return count
    }
}