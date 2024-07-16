package base

/**
 * Условные выражения представляют некоторое условие, которое
 * возвращает значение типа Boolean: либо true (если условие истинно), либо false (если условие ложно).
 */
fun main() {

    //Операции отношения.

    val b1 = 8
    val b2 = 4
    var b3 = b1 < b2
    println(b3)
    b3 = (b1 * 7) > b2
    println(b3)
    println(b1 != b2)
    println()

    //Логические операции.

    //Операндами в логических операциях являются два значения типа Boolean. Нередко логические операции объединяют несколько операций отношения:
    val u = true
    val uu = false
    val uuu = u && uu//u and uu
    val uuuu = (23 < 5) || (23 >= 9)//(23 < 5) or (23 >= 9)
    val u3 = u xor uu//xor: возвращает true, если только один из операндов равен true. Если операнды равны, возвращается false.
    println(uuu)
    println(uuuu)
    println(u3)

    val s = 99
    //in: возвращает true, если операнд имеется в некоторой последовательности.
    val y = s in 2..7
    val yy = s !in 1..5
    println(y)
    println(yy)
}