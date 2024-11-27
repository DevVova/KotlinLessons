package generics.p40

fun main() {
    println(getBiggest(23, 3))
    getInfo("apple", 45, 77)

    val mes1 = SmartPhone("Hello")
    val m1 = Messenger<SmartPhone>()
    m1.send(mes1)
    val mes2 = Pager("Good")
    val m2 = Messenger<Pager>()
    m2.send(mes2)
}

fun <T : Comparable<T>> getBiggest(a: T, b: T): T {
    return if (a > b) a else b
}

fun <K, V> getInfo(a: K, price1: V, price2: V) where V : Comparable<V>,
                                                     V : Number {
    val biggest = if (price1 > price2) price1 else price2
    println("The $a have biggest price $biggest.")
}

interface Message {
    val text: String
}

interface Logger {
    fun log()
}

class SmartPhone(override val text: String) : Message, Logger {
    override fun log() {
        println(text)
    }
}

class Pager(override val text: String) : Message, Logger {
    override fun log() {
        println("$text from Pager.")
    }
}

class Messenger<T> where T : Message,
                         T : Logger {
    fun send(mes: T) {
        mes.log()
    }
}