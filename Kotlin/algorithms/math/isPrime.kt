package com.raj.algorithms.math

import java.math.BigInteger
import kotlin.math.sqrt

fun main(args: Array<String>) {
    println("${isPrime(5)}")
    println(isPrime(52))
    println(isPrime(31))
    println(isPrime(1433))
    println(isPrime(8763857775536878331L))
    println("primality check using bigInteger Class -${bigIntIsPrime("8763857775536878331")}")
}

fun isPrime(n: Long): Boolean = if (n < 2)
    false
else if (n % 2 == 0L || n % 3 == 0L)
    false
else {
    val sqrt = sqrt(n.toDouble()).toLong()
    for (i in 5..sqrt + 1 step 6) if (n % i == 0L || n % (i + 2) == 0L) {
        false
    }

    true
}


//using predefined bigInteger class to verify the result
fun bigIntIsPrime(s: String): Boolean {
    val bg: BigInteger = BigInteger(s)
    return bg.isProbablePrime(20)
}

