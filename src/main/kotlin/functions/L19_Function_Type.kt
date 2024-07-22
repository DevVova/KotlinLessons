package functions

/**
 * В Kotlin все является объектом, в том числе и функции. И функции, как и другие объекты,
 * имеют определенный тип.
 * Переменная может представлять функцию. С помощью типа функции можно определить, какие
 * именно функции переменная может представлять.
 */
fun main() {
    var operation: (Int, Int) -> Int = ::sum2
    var result = operation(23, 1)
    println(result)

    operation = ::subtract
    result = operation(7, 23)
    println(result)
}

fun sum2(a: Int, b: Int): Int {
    return a + b
}

fun subtract(a: Int, b: Int): Int {
    return a - b
}