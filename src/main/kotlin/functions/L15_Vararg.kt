package functions

/**
 * Функция может принимать переменное количество параметров одного типа. Для определения таких
 * параметров применяется ключевое слово vararg.
 */
fun main() {
    println(add(34, 22, 12))
    info("trader","Ted", "Vova", "Nick")

    val arr = intArrayOf(5, 6, 7)//Именно так intArrayOf.
    addMore(2, *arr)
}

fun add(vararg num: Int): Int {
    var res = 0
    for (i in num) {
        res += i
    }
    return res
}

//vararg лучше писать в конце у функции, чтобы потом не использовать именованные параметры.
fun info(profession: String, vararg humans: String) {
    print("У ")
    var n = 0
    for (i in humans) {
        if (n != 0) print(" и ")
        print(i)
        n = 1
    }
    print(" профессия - $profession.")
    println()
}

fun addMore(koef: Int, vararg num: Int) {
    var koeff = koef
    var res = 0
    for (i in num) {
        res = i * koeff
        print("$res ")
        koeff++
    }
}