package functions

/**
 * Функция может возвращать некоторый результат. В этом случае после списка параметров
 * через двоеточие указывается возвращаемый тип. А в теле функции применяется оператор
 * return, после которого указывается возвращаемое значение.
 */
fun main() {
    val arr = myArrayDoubleOf(2.1, 9.0, 13.4, 22.7, 2.8)
    for (a in arr) {
        print("$a ")
    }
    println()

    anyFun(23)
    anyFun(-5)
}

fun myArrayDoubleOf(vararg numbers: Double): DoubleArray {
    var size = 1
    var index = 0
    print("Вот образованный вами массив: ")
    for (n in numbers) {
        if (size > 1) print(", ")
        print(n)
        size++
    }
    println(".")
    val outputArray = DoubleArray(size - 1) {1.1}
    for (n in numbers) {
        outputArray[index] = n
        index++
    }
    return outputArray
}

//Если функция ничего не возвращает, то оператор return можно использовать для выхода из неё.
fun anyFun(aa: Int) {
    if (aa < 0) {
        println("aa < 0")
        return
    } else println(aa)
}