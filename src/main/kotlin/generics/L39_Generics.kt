package generics

/**
 * Generics или обобщения представляют технику, посредством которой, методы
 * и классы могут использовать объекты, типы которых на момент определения
 * классов и функций неизвестны. Обобщения позволяют определять шаблоны,
 * в которые можно подставлять различные типы.
 * То есть обобщения это шаблоны, позволяющие подставлять любые типы.
 */
fun main() {
    val myBall = Ball(56)
    myBall.info()

    val bigArray = getBiggest(arrayOf(3, 22, 77), arrayOf("Tom", "Vova", "Sam", "David"))
    bigArray.forEach { item ->
        print("$item  ")
    }
    println()

    val human = Human(23, "Tom")
    println(human.age)
}

class Ball<T>(private val price: T) {
    fun info() {
        println("Мяч стоит $price.")
    }
}

fun <T> getBiggest(a: Array<T>, b: Array<T>): Array<T> {
    return if (a.size > b.size || a.size == b.size) a else b
}

//Пример использования сразу нескольких параметризованных типов.
class Human<K, V>(val age: K, val name: V)