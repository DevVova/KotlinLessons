package recursion

fun main() {
    val res = factorial(4)
    println(res)
}

fun factorial(num: Int): Int {
    //Базовый случай должен обязательно присутствовать и здесь это if (num == 0) 1.
    return if (num == 0) 1 else num * factorial(num - 1)
}