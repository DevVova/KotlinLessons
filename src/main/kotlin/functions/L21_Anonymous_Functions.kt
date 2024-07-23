package functions

fun main() {
    doIt(8, 33, fun(x: Int, y: Int): Int = x * y)
    val f1 = fun(a: Int, b: Int) = a - b//Анонимные функции выглядят как обычные за тем исключением, что они не имеют имени.
    doIt(344, 21, f1)
    val f2 = fun(k: Int, l: Int) = k * l / 2
    doIt(2, 45, f2)//Анонимную функцию можно передавать в функцию, если параметр соответствует типу этой функции.

    //Возвращение анонимной функции из функции.
    var res11 = selectOp(3)
    doIt(24, 13, res11)
    res11 = selectOp(55)
    doIt(3444, 2323, res11)
    val res22 = selectOp(1)
    println(res22(14, 4))
}

fun doIt(a: Int, b: Int, op: (Int, Int) -> Int) {
    println(op(a, b))
}

fun selectOp(key: Int): (Int, Int) -> Int {
    return when(key) {
        1 -> fun(a, b) = a + b
        2 -> fun(a, b) = a - b
        3 -> fun(a, b) = a * b
        else -> fun(_, _) = 0
    }
}