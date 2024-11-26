package generics.p39

import java.time.Instant

fun main() {
    val instant = Instant.now()
    val timeMillisecond = instant.toEpochMilli()
    val pullBackToInstant = Instant.ofEpochMilli(timeMillisecond)

    val arr1 = Array(2) {23}
    val arr2 = arrayOf(2, 112, 3)
    println(getBiggest(arr1, arr2)[1])

    println(pullBackToInstant)

    val c1 = Candlestick<Instant>(
        time = instant,
        volume = 345
    )
    println(c1.time)

    val c2 = Candlestick(
        time = timeMillisecond,
        volume = 45666
    )
    println(c2.volume)

    val p1 = PriceBar<Instant, Int>(instant, 39999)
    println(p1.getTime())

    val p2 = PriceBar(timeMillisecond, 3330)
    println(p2.getVolume(Instant.now()))
    println(p2.volume)
}

class Candlestick<T>(val time: T, val volume: Int)

class PriceBar<K, V>(private val time: K, val volume: V) {
    fun getTime(): K {
        return time
    }

    fun <F> getVolume(inputVolume: F): F {
        return inputVolume
    }
}

fun <T> getBiggest(num1: Array<T>, num2: Array<T>): Array<T> {
    return if (num1.size > num2.size) num1 else num2
}
