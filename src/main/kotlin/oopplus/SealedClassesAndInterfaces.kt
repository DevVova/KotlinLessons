package oopplus

/**
 * В Kotlin sealed class (запечатанный класс) используется для создания ограниченной
 * иерархии классов. Это значит, что такие классы могут иметь строго определённое
 * количество подклассов, и все они должны быть объявлены либо в том же файле, либо
 * внутри самого запечатанного класса. Это помогает в ситуациях, когда нужно работать
 * с фиксированным набором вариантов и обрабатывать их в разных контекстах
 * (например, в when выражении), исключая необходимость обработки каких-то
 * неучтённых подклассов.
 *
 * sealed interface в Kotlin, как и sealed class, используется для создания ограниченных
 * иерархий типов, но с той разницей, что вместо класса используется интерфейс. Это
 * позволяет создавать гибкую структуру, где реализации могут быть как классами, так
 * и объектами, при этом сохраняя возможность строгого контроля над тем, какие классы
 * или объекты могут реализовать этот интерфейс.
 */
fun main() {
    val bobik = Animal.Dog("Bobik")
    val murzik = Animal.Cat("Murzik", "White")
    val anyOne = Animal.AnyAnimal

    infoAnimal(bobik)
    infoAnimal(murzik)
    infoAnimal(anyOne)

    println()

    val toyota = Car(29000)
    val audi = Audi
    val bmv = BMV
    val porshe = SuperCar(true)

    infoMovable(toyota)
    infoMovable(audi)
    infoMovable(porshe)

    infoUseful(porshe)
    infoUseful(bmv)
}

sealed class Animal(val name: String) {
    class Dog(nameDog: String) : Animal(nameDog)
    class Cat(nameCat: String, val color: String) : Animal(nameCat)
    data object AnyAnimal : Animal("Any") {
        fun info() {
            println("This is an object.")
        }
    }
}

fun infoAnimal(animal: Animal) {
    when (animal) {
        is Animal.Dog -> println("Это собака по имени ${animal.name}.")
        is Animal.Cat -> println("Это кошка по имени ${animal.name} и цветом ${animal.color}.")
        is Animal.AnyAnimal -> println("Это непонятно кто по имени ${animal.name}.")
    }
}

sealed interface Movable

sealed interface Useful

class Car(val price: Int) : Movable

data object Audi : Movable

class SuperCar(val best: Boolean) : Movable, Useful

data object BMV : Useful

fun infoMovable(m: Movable) {
    when (m) {
        is Car -> println("Это машина стоимостью ${m.price}.")
        is Audi -> println("This is Audi.")
        is SuperCar -> println("А это ${m.best} по полезности суперкар. Supercar.")
    }
}

fun infoUseful(u: Useful) {
    when(u) {
        is BMV -> println("Это БМВ.")
        is SuperCar -> println("А это ${u.best} по полезности суперкар. ")
    }
}