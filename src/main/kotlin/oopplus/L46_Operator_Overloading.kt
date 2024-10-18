package oopplus

/**
 * Kotlin позволяет определить для типов ряд встроенных операторов. Для определения
 * оператора для типа определяется функция с ключевым словом operator.
 * После ключевого слова fun идет название оператора и далее скобки. Если оператор
 * бинарный, то в скобках указывается параметр оператора. После скобок через двоеточие
 * указывается возвращаемый тип.
 *
 * Здесь я рассмотрел только переопределение двух операторов, а их куча. Я не буду их
 * все писать, да и вообще я считаю, что нужно стараться обходиться теми операторами, что
 * есть.
 */
fun main() {
    val c1 = Counter(34)
    val c2 = Counter(15)
    val c3 = c1 + c2
    println(c3.value)
    val c4: Counter = 99 + c2//Справа писать 99 от с2 нельзя будет ошибка.
    println(c4.value)
    val c5 = SuperCounter(8)
    var c6 = c5 + 77//А вот здесь уже можно писать где хочешь 77.
    println(c6.value)
    c6 = c1 + c2
    println(c6.value)
    val res = ++c6
    println(res.value)
}

open class Counter(open var value: Int) {
    operator fun plus(counter: Counter): Counter {
        return Counter(this.value + counter.value)
    }

    //Ниже пример переопределения инкремента. Оператор у нас унарный.
    operator fun inc(): Counter {
        return Counter(value + 1)
    }
}

class SuperCounter(override var value: Int) : Counter(value) {
    operator fun plus(integer: Int): Counter {
        return Counter(this.value + integer)
    }
}

/**
 * Операторы могут быть определены как в виде функций класса, так и в виде функций
 * расширений. А это значит, что мы можем переопределить операторы даже для встроенных типов.
 */
operator fun Int.plus(counter: Counter): Counter {
    return Counter(this + counter.value)
}