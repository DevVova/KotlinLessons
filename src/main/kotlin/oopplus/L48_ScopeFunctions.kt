package oopplus

/**
 * Scope-функции (можно перевести как "функции контекста" или "функции области видимости")
 * позволяют выполнить для некоторого объекта некоторый код в виде лямбда-выражение.
 * При вызове подобной функции, создается временная область видимости. В этой области
 * видимости можно обращаться к объекту без использования его имени.
 *
 * В Kotlin есть пять подобных функций: let, run, with, apply и also. Эти функции
 * похожи по своему действию и различаются прежде всего по параметрам и возвращаемым результатам.
 */
fun main() {
    val myOrder = Orders(23.20, 3.5)

    //let
    /**
     * Лямбда-выражение в функции let в качестве параметра it получает объект, для которого
     * вызывается функция. Возвращаемый результат функции let представляет результат данного
     * лямбда-выражения.
     *
     * inline fun <T, R> T.let(block: (T) -> R): R
     */
    val sl = myOrder.stopLoss?.let {
        println("Stop loss equals $it.")
        it
    }
    println("SL = $sl")

    val tp = myOrder.let {
        println("Take profit equals ${it.takeProfit}.")
        it.takeProfit
    }

    if (tp != null && sl != null) {
        println("Разница равна ${tp - sl}")
    }
    //А можно было и так.
    val different = tp?.let { t -> sl?.let { s -> t - s } }
    println(different)


    //with
    /**
     * Лямбда-выражение в функции with в качестве параметра this получает объект, для
     * которого вызывается функция. Возвращаемый результат функции with представляет
     * результат данного лямбда-выражения.
     * Часто with применяется для установки свойств объектов.
     *
     * inline fun <T, R> with(receiver: T, block: T.() -> R): R
     */
    var diff = with(myOrder) {
        val res = if (stopLoss != null && this.takeProfit != null) {
            takeProfit - stopLoss//То есть можно писать this.takeProfit, а не takeProfit.
        } else 0.0
        res
    }
    println(diff)
    //Или вот аналог с let.
    diff = myOrder.let {
        val res = if (it.takeProfit != null && it.stopLoss != null) {
            it.takeProfit - it.stopLoss
        } else 0.0
        res
    }
    println(diff)


    //run
    /**
     * Лямбда-выражение в функции run в качестве параметра this получает объект,
     * для которого вызывается функция. Возвращаемый результат функции run представляет
     * результат данного лямбда-выражения.
     *
     * Функция run похожа на функцию with за тем исключением, что run реализована
     * как функция расширения. Функция run также принимает объект, для которого надо
     * выполнить блок кода, в качестве параметра. Далее в самом блоке кода мы можем
     * обращаться к общедоступным свойствам и методам объекта без его имени.
     */
    val maxValue = myOrder.run {
        val max = if (takeProfit != null && stopLoss != null) {
            if (takeProfit > stopLoss) takeProfit
            else stopLoss
        } else 0.0
        if (max == 0.0) println("Либо тейкпрофит или стоплосс или оба сразу равны null")
        max
    }
    println(maxValue)

    //По сути, различие между let и run действительно сводится к тому, как мы обращаемся к объекту.
    var t = myOrder.takeProfit?.run { this + 3.1 }//Или ещё проще var t = myOrder.takeProfit?.run { + 3.1 }
    println(t)
    t = myOrder.takeProfit?.let { it + 4}
    println(t)

                                         //apply
    /**
     * Лямбда-выражение в функции apply в качестве параметра this получает объект, для
     * которого вызывается функция. Возвращаемым результатом функции фактически является
     * передаваемый в функцию объект для которого выполняется функция.
     *
     * Распространенным сценарием применения функции apply() является построение объекта
     * в виде реализации вариации паттерна "Строитель".
     */
    val teacher = Employee()
    teacher.changeName("Sam")
    teacher.changeAge(38)
    println("The teacher name is ${teacher.name}. He is ${teacher.age} years old.")


    //also
    /**
     * Лямбда-выражение в функции also в качестве параметра it получает объект, для которого
     * вызывается функция. Возвращаемым результатом функции фактически является передаваемый
     * в функцию объект для которого выполняется функция.
     * Эта функция аналогична функции apply за тем исключением, что внутри also объект, над
     * которым выполняется блок кода, доступен через параметр it.
     */
    val myBook = Book111()
    myBook.changePriceWithLet(300)
    println(myBook.price)
    myBook.changePriceWithRun(500)
    println(myBook.price)
    myBook.changePriceWithWith(600)
    println(myBook.price)
    myBook.changePriceWithApply(700)
    println(myBook.price)
    myBook.changePriceWithAlso(3500)
    println(myBook.price)
}

data class Orders(val takeProfit: Double?, val stopLoss: Double?)

data class Employee(var name: String = "", var age: Int = 0) {
    fun changeName(newName: String): Employee {
        return apply { name = newName }
    }
    fun changeAge(newAge: Int): Employee = apply { age = newAge}
}

//Пример ниже хорошо показывает в чём же между всеми этими scope функциями разница.
class Book111(var price: Int = 0) {
    fun changePriceWithRun(newPrice: Int) = run {price = newPrice}
    fun changePriceWithLet(newPrice: Int) = let {
        it.price = newPrice
        it.price
    }
    fun changePriceWithApply(newPrice: Int): Book111 = apply { this.price = newPrice }
    fun changePriceWithWith(newPrice: Int) = with(this) {
        this.price = newPrice
    }
    fun changePriceWithAlso(newPrice: Int): Book111 = also { it.price = newPrice }
}