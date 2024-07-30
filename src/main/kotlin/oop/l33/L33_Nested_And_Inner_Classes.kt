package oop.l33

/**
 * В Kotlin одни классы могут быть определены в других классах. Такие классы называют
 * вложенными классами или nested classes. Они обычно выполняют какую-то вспомогательную роль,
 * а определение их внутри класса или интерфейса позволяет разместить их как можно ближе к
 * тому месту, где они непосредственно используются.
 */
fun main() {
    val vova = Person.Trading("Binance")
    vova.infoTrading()
    val petya = Person("Petya", "IB")
    petya.infoTrader()

    //Ниже примеры как создавать объекты внутренних классов.
    val alex = Person2(23, "Alex").TradingInner(34)
    alex.infoT()

    val sam = Person2(17, "Sam")
    sam.info()
    sam.TradingInner(28).infoT()
}

//Пример nested класса. В нём мы не можем обращаться к свойствам и функциям внешнего класса.
class Person(val name: String, private val brokerIn: String) {
    private var age: Int = 18

    private val trader: TradingPrivate = TradingPrivate(brokerIn)

    fun infoPerson() {
        println("He's $name. He's $age years old.")
    }

    class Trading(private val broker: String) {
        fun infoTrading() {
            println("He trade with $broker.")
        }
    }

    private class TradingPrivate(val broker: String)

    fun infoTrader() {
        println("Her broker is a ${trader.broker}.")
    }

    //Ниже пример вложенного интерфейса.
    interface Driver {
        fun driving()
    }
}

//Ниже уже пример inner класса, в котором мы можем обращаться к свойствам и функциям.
class Person2(val age: Int, val name: String) {
    private var profession = "trader"

    fun info() {
        println("He is $name. He's $age years old. He is a $profession.")
    }

    inner class TradingInner(val age: Int) {
        fun infoT() {
            println("He is ${this@Person2.name}. He's ${this.age} years old")//Вместо ${this.age} можно было просто $age, то есть age именно этого класса, а не внешнего.
            this@Person2.info()//This нужно, чтобы указать к какой хрени обращаемся конкретно, это полезно если имена одинаковые.
        }
    }
}