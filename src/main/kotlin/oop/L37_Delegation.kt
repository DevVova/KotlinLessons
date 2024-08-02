package oop

/**
 * Делегирование представляет паттерн объектно-ориентированного программирования,
 * который позволяет одному объекту делегировать/перенаправить все запросы другому
 * объекту. В определенной степени делегирование может выступать альтернативой
 * наследованию. И преимуществом Kotlin в данном случае состоит в том, что Kotlin
 * нативно поддерживает данный паттерн, предоставляя необходимый инструментарий.
 */
fun main() {
    //Ниже объекты классы которых по-разному реализуют интерфейсы.
    val takeProfitForOrderBuy1 = TP1()
    val takeProfitForOrderBuy2 = TP2()
    val stopLossForOrderBuy1 = SL1()
    val stopLossForOrderBuy2 = SL2()

    //А теперь создаём объекты, делегирующие свои действия другим определённым объектам.
    val myOrder = Order(takeProfitForOrderBuy1, stopLossForOrderBuy2)
    val myOrder2 = Order2(takeProfitForOrderBuy2, stopLossForOrderBuy1)
    val myOrder3 = Order3(takeProfitForOrderBuy1, stopLossForOrderBuy1)

    myOrder.takeProfit()
    myOrder.stopLoss()
    myOrder.info()
    println()

    myOrder2.stopLoss()
    myOrder2.takeProfit()
    myOrder2.info()
    println()

    myOrder3.info()
    println()

    //Делегирование свойств.
    val myDevice = MFU("Epson")
    val oDevice = MyMFU("Company mfu.", myDevice)
    println("${oDevice.name}\t${oDevice.model}")
    oDevice.model = "Sony"
    println("${oDevice.name}\t${oDevice.model}")
}

//Делегирование через интерфейс явное. Оно гибче чем стандартное с использованием by.

//Интерфейс определяет контракт(действие) который нужно реализовать.
interface StopLoss {
    fun stopLoss()
    fun info()
}

//Интерфейс определяет контракт(действие) который нужно реализовать.
interface TakeProfit {
    fun takeProfit()
}

//Класс реализующий интерфейс.
class SL1 : StopLoss {
    override fun stopLoss() {
        println("stop loss 1.")
    }

    override fun info() {
        println("info stop loss 1.")
    }
}

//Класс реализующий интерфейс.
class SL2 : StopLoss {
    override fun stopLoss() {
        println("stop loss 2.")
    }

    override fun info() {
        println("info stop loss 2.")
    }
}

//Класс реализующий интерфейс.
class TP1 : TakeProfit {
    override fun takeProfit() {
        println("take profit 1.")
    }
}

//Класс реализующий интерфейс.
class TP2 : TakeProfit {
    override fun takeProfit() {
        println("take profit 2.")
    }
}

//Класс-делегат: Принимает объект, реализующий интерфейс, и делегирует ему вызовы методов.
class Order(private val tp: TakeProfit, private val sl: StopLoss) : TakeProfit, StopLoss {
    override fun takeProfit() {
        tp.takeProfit()
        println("This is class delegate.")//Это к примеру будет дополнением к обычной реализации. Вот для чего нужно явное делегирование.
    }

    override fun stopLoss() {
        sl.stopLoss()
        println("This is class delegate.SL.")
    }

    override fun info() {
        sl.stopLoss()
        println("This is class delegate.Info about SL.")
    }
}

//А вот класс-делегат использующий by и стандартное делегирование средствами языка Kotlin.
class Order2(tpBy: TakeProfit, slBy: StopLoss) : TakeProfit by tpBy, StopLoss by slBy
//Здесь минус в том что нельзя добавить дополнительную функциональность к реализации.

//Ниже пример когда функцию info не делегируют объекту slBy.
class Order3(tpBy: TakeProfit, slBy: StopLoss) : TakeProfit by tpBy, StopLoss by slBy {
    override fun info() {
        println("This function is not delegate fot object.")
    }
}


//А вот делегирование свойств.
interface Scanner {
    var model: String
}

class MFU(override var model: String): Scanner

class MyMFU(val name: String, m: Scanner) : Scanner by m