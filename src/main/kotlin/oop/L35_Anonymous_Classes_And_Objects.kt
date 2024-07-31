package oop

/**
 * Иногда возникает необходимость создать объект некоторого класса, который больше нигде
 * в программе не используется. То есть класс необходим только для создания только одного
 * объекта. В этом случае мы, конечно, можем, как и обычно, определить класс и затем
 * создать объект этого класса. Но Kotlin для таких ситуаций предоставлять возможность
 * определить объект анонимного класса.
 *
 * Анонимные классы не используют ключевое слово class для определения.
 * Они не имеют имени, но, как и обычные классы могут наследовать другие классы или применять
 * интерфейсы. Объекты анонимных классов называют анонимными объектами.
 *
 * Для определения анонимного объекта применяется ключевое слово object.
 */
fun main() {
    car2.printInfo2()

    //Создаётся анонимный объект, то есть объект анонимного класса.
    val car3 = object : SuperCar("orange") {
        var price = 8000
        fun p() {
            super.printInfo()
            println("Its price is $price.")
        }
    }

    car3.p()

    //Пример как в функцию в качестве аргумента передаётся анонимный объект.
    driving(object : SuperCar("green") {
        var price = 70000
        override fun printInfo() {
            println("Wow.")
        }
    })

    val myCar = buyCar("BMV", 45000)
    myCar.printText()
}

//Если анонимный объект определяется вне функции, как глобальный объект, то пишется так.
object car2 : SuperCar("blue") {
    var price = 9000

    fun printInfo2() {
        println("Its price is $price.")
    }

    override fun printInfo() {
        super.printInfo()
        println("Its price is $price.")
    }
}

open class SuperCar(val color: String = "Red") {
    open fun printInfo() {
        println("Its color is $color.")
    }
}

fun driving(car: SuperCar) {
    car.printInfo()
}

//Анонимный объект как результат функции. Так можно делать только если функция private.
private fun buyCar(nameCar: String, priceCar: Int) = object {
    fun printText() {
        println("You buy $nameCar. Its price is $priceCar.")
    }
}