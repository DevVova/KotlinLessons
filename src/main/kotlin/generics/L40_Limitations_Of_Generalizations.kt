package generics

/**
 * Ограничения обобщений (generic constraints) ограничивают набор типов,
 * которые могут передаваться вместо параметра в обобщениях.
 */
fun main() {
    val res = getBiggest(34, 78)
    println(res)

    val petya = Human2(17, "Petya")
    println(petya.name)

    var myMessage: Message = SMS("How are you?")
    send(myMessage)
    myMessage = EMail("Where are you from?")
    send(myMessage)

    val res2 = getBiggestNumber(56, 89)
    println(res2)

    val sms2 = SMS("Hello friend!")
    val mes = Messenger<SMS>()
    mes.send(sms2)
}

fun <T : Comparable<T>> getBiggest(a: T, b: T): T {
    return if (a > b) a else b
}

//По умолчанию все обобщения уже имеют ограничения в виде типа Any? .
class Human2<K : Any?, V>(val age: K, val name: V)

//Подобным образом мы можем использовать в качестве ограничений собственные типы.
interface Message {
    val text: String
}

class SMS(override val text: String) : Message, Logger {
    override fun log() {
        println(text)
    }
}
class EMail(override val text: String) : Message

fun <T : Message> send(t: T) {
    println("${t.text}.")
}

//Установка нескольких ограничений.
//Для функции.
fun <T> getBiggestNumber(a: T, b: T): T where T : Comparable<T>,
                                              T : Number {
    return if (a > b) a else b
}

interface Logger {
    fun log()
}

//Для класса.
class Messenger<T> where T: Logger, T: Message {
    fun send(t: T) {
        t.log()
    }
}