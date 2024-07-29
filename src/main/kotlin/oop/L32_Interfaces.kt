package oop

/**
 * Интерфейсы представляют контракт - набор функциональности, который должен реализовать
 * класс. Интерфейсы могут содержать объявления свойств и функций, а также могут содержать
 * их реализацию по умолчанию. Интерфейсы позволяют реализовать в программе концепцию
 * полиморфизма и решить проблему множественного наследования, поскольку класс может
 * унаследовать только один класс, зато интерфейсов он может реализовать множество.
 */
fun main() {
    val myCar = Car(2303)
    myCar.info()
    myCar.move()
    val superCar: Movable = Car(30)

    //И реализация интерфейса также означает, что мы можем рассматривать объекты классом Car как объекты Movable. И тут в дело вступает полиморфизм.
    priceInfo(myCar)
    priceInfo(superCar)

    val vova = WorkingStudent("Vova")
    vova.work()
    val gena: Student = WorkingStudent("Gena")
    gena.study()
    workHuman(vova)
    studyHuman(vova)
    studyHuman(gena)
    vova.info2()
    vova.info3()
}

fun priceInfo(obj: Movable) = println("Its price is ${obj.price}.")

interface Movable {
    val price: Int//Значения для свойств не задают, можно только функции определять.

    fun move() {
        println("It's moving.")
    }
    fun info()
}

class Car(override val price: Int): Movable {
    override fun info() {
        println("It is a car.")
    }

    //Если захотим, то можем переопределить функцию в интерфейсе, которая уже определена.
    override fun move() {
        println("Moving in a Car.")
    }
}

//Множественная реализация интерфейсов.
interface Worker {
    fun work()
    fun info2()
    fun info3() {
        println("Work.")
    }
}

interface Student {
    fun study()
    fun info2()
    fun info3() = println("Study.")
}

class WorkingStudent(val name: String): Worker, Student {
    override fun study() {
        println("$name is studying.")
    }

    override fun work() {
        println("$name is working.")
    }

    override fun info2() {
        println("He is $name.")
    }

    //Ниже пример вызова реализации функции из интерфейса, определённой с целью переопределить.
    override fun info3() {
        super<Worker>.info3()
        super<Student>.info3()
        println("The end!!!!!!!!!!!!!!!")
    }
}

fun studyHuman(obj: Student) = obj.study()
fun workHuman(obj: Worker) = obj.work()