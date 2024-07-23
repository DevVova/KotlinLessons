package functions

/**
 * Замыкание (closure) представляет объект функции, который запоминает свое лексическое
 * окружение даже в том случае, когда она выполняется вне своей области видимости.
 */
fun main() {
    val f1 = outer1()
    f1()
    val f2 = outer2(23)(12)

    //Ниже пример можно было вот так - "val f3 = outer3(45)()".
    val f3 = outer3(45)
    f3()

    //В данном примере лямбда-функция, переданная в forEach, захватывает переменную hi из внешней области видимости и использует её внутри.
    val names = arrayOf("Vova", "Kolya", "Ted")
    val hi = "Hello! "
    names.forEach { name ->
        println("$hi $name.")
    }

    //Вот простой пример замыкания с использованием лямбды.
    val greet = { name: String -> println("Hello, $name!") }
    greet("World") // Output: Hello, World!
    greet("Sam")
}

fun outer1(): () -> Unit {
    val a = 9//Это лексическое окружение функции inner().
    fun inner1() {
        println("${a * 9}")
    }
    return ::inner1
}

fun outer2(a: Int): (Int) -> Int {
    return { b: Int ->
        println("${a * b}")
        a * b
    }
}

fun outer3(x: Int): () -> Unit {
    val k = fun() = println(x)
    return k
}