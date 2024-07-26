package oop

/*
Ниже переменные верхнего уровня: privateVal будет видна в этом файле и в другом из этого же пакета, но в другом
пакете будет уже не видна, а вот internalVal будет и в другом пакете видна, но не будет видна в другом модуле.
Protected для переменных верхнего уровня нет, этот модификатор используют только в классах.
 */
private val privateVal = 991
internal val internalVal = 999
/**
 * Все используемые типы, а также компоненты типов (классы, объекты, интерфейсы,
 * конструкторы, функции, свойства) имеют определенный уровень видимости, определяемый
 * модификатором видимости (модификатором доступа). Модификатор видимости определяет,
 * где те или иные типы и их компоненты доступны и где их можно использовать.
 *
 * В Kotlin есть следующие модификаторы видимости:
 *
 * Private: классы, объекты, интерфейсы, а также функции и свойства, определенные вне
 * класса, с этим модификатором видны только в том файле, в котором они определены.
 * Члены класса с этим модификатором видны только в рамках своего класса.
 *
 * Protected: члены класса с этим модификатором видны в классе, в котором они определены,
 * и в классах-наследниках.
 *
 * Internal: классы, объекты, интерфейсы, функции, свойства, конструкторы с этим
 * модификатором видны в любой части модуля, в котором они определены. Модуль
 * представляет набор файлов Kotlin, скомпилированных вместе в одну структурную единицу.
 * Это может быть модуль IntelliJ IDEA или проект Maven.
 *
 * Public: классы, функции, свойства, объекты, интерфейсы с этим модификатором видны
 * в любой части программы. (При этом если функции или классы с этим модификатором
 * определены в другом пакете их все равно нужно импортировать).
 *
 * Если модификатор видимости явным образом не указан, то применяется модификатор public.
 */
fun main() {
    val kzt = Money("Kazakhstan")
    kzt.p()
    val usd = Usd("USA")
    usd.plusP()
    val petya = Employee1("Petya", 27)
    petya.info()
    println("internalVal = $internalVal. privateVal = $privateVal.")
}

open class Money(countryIn: String) {
    private val country: String = countryIn
    protected open var count: Int = 22

    protected open fun pr() {
        println("$count money.")
    }

    internal fun p() {
        println()
    }
}

class Usd(c: String): Money(c) {
    override var count = 13

    fun plusP() {
        print("This is a new function.")
        p()
    }

    override fun pr() {
        println("$count usd.")
    }
}

//Ниже пример использования приватного конструктора.
open class Person1 private constructor(val name: String) {
    var age = 66
    protected constructor(n: String, a: Int) : this(n) {
        age = a
    }
    open fun info() {
        println("He is $name.")
    }
}

class Employee1(name: String, age: Int): Person1(name, age) {
    override fun info() {
        println("He's $name. He is $age years old.")
    }
}