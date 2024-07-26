package oop

/**
 * Kotlin позволяет переопределять в производном классе функции и свойства, которые определенны
 * в базовом классе. Чтобы функции и свойства базового класса можно было переопределить, к ним
 * применяется аннотация open. При переопределении в производном классе к этим функциям применяется
 * аннотация override.
 */
fun main() {
    val robot = Robot(3000, "Robot")
    println(robot.name)
    robot.priceInfo()
    val android = Android(n = "Android x")
    android.priceInfo()
    println(android.name)
    val cl = Class333()
    cl.ff()
}

open class Robot constructor(open var price: Int = 6000, open val name: String) {
    open fun priceInfo() {
        println("Price of robot is $price.")
    }
}

//Здесь при переопределении свойства price, своё название использовать нельзя, а только наименование из базового класса.
//А вот во втором случае разрешено.
class Android(override var price: Int = 9000, n: String): Robot(price, n) {
    override val name: String
        get() = "Android"
    override fun priceInfo() {
        println("Price of android is $price.")
    }
}

//Переопределение методов класса по иерархии.
open class Class111 {
    open fun f() {
        println("This is class Class.")
    }
    open fun ff() {
        println("This is function final.")
    }
    open fun fff() {
        println("This is class Class fff.")
    }
}

open class Class222: Class111() {
    override fun f() {
        println("This is class Class222.")
    }
    //Ниже пример когда в последующих классах наследниках мы не хотим переопределения функции.
    final override fun ff() {
        println("This is function final222.")
    }
}

class Class333: Class222() {
    override fun fff() {
        println("This is class Class fff333.")
    }

    override fun f() {
        println("This is class Class333.")
    }
}