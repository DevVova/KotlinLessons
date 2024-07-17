package base

/**
 * Условные конструкции позволяют направить выполнение программы по одному из путей в зависимости от условия.
 * Конструкция if...else одна из них.
 */
fun main() {
    val a = 2
    val b = 3
    if (a > b) println("a > b") else if (a == b) println("a == b") else println("a < b")

    //Ниже пример условной конструкции, которая возвращает значение. То есть условная конструкция может быть выражением.
    val c = if (a == b) 0 else if (a < b) {
        a
        println("a is <")
    } else b
    println(c)
}