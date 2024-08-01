package oop

/**
 * Enums или перечисления представляют тип данных, который позволяет определить
 * набор логически связанных констант. Для определения перечисления применяются
 * ключевые слова enum class.
 * Каждая константа фактически представляет объект данного перечисления.
 * Enum классы могут иметь конструкторы, которые вызываются для каждой константы.
 * Enum классы могут содержать методы и свойства, которые можно вызывать для каждой константы.
 */
fun main() {
    val myOrder: Order = Order.BUY
    println(myOrder.value)
    println(myOrder)
    myOrder.status = false
    println(myOrder.ordinal)//Возвращает порядковый номер константы.
    println(myOrder.name)//Возвращает название константы в виде строки.
    println(Order.entries)//Возвращает массив констант текущего перечисления.
    println(Order.valueOf("SELL"))//Возвращает объект перечисления по названию константы.
    myOrder.buy()

    val trend = Trend.SHORT
    println(Trend.BUY.speed)
    trend.trade()
    println(trend.ordinal)

    doOperation(24, 88, Operation.MULTIPLY)
}

enum class Order(val value: Int) {
    BUY(1), SELL(2);
    var status = true
    fun buy() {
        println("buy")
    }
}

/*
Константы перечисления могут определять анонимные классы, которые могут иметь
собственные методы и свойства или реализовать абстрактные методы класса перечисления.
Также сам класс перечислений может наследовать интерфейсы, но не классы.
 */
enum class Trend: Printable {
    SHORT{
        override val speed = 23
        override fun trade() {
            println("sell now.")
        }

        override fun printDo() {
            println("Let's short.")
        }

    },
    BUY{
        override val speed = 13
        override fun trade() {
            println("buy now.")
        }

        override fun printDo() {
            println("Let's buy.")
        }
    };
    abstract val speed: Int
    abstract fun trade()
}

interface Printable {
    fun printDo()
}

enum class Operation {
    ADD, SUBTRACT, MULTIPLY
}

//Здесь else не нужен, так как констант всегда ограниченное количество.
fun doOperation(a: Int, b: Int, op: Operation) {
    val res = when (op) {
        Operation.ADD -> a + b
        Operation.SUBTRACT -> a - b
        Operation.MULTIPLY -> a * b
    }
    println(res)
}