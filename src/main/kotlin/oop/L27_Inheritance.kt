package oop

/*
    Наследование позволяет создавать классы, которые расширяют функциональность или
изменяют поведение уже существующих классов.
    Стоит отметить, что те классы, которые явным образом не наследуются от других классов,
неявно наследуются от класса Any.
 */
fun main() {
    val vova = Employee()
    vova.age = 46
    vova.name = "Vova"
    vova.printInfo()
    val tom = Employee2()
    tom.printInfo()
    val ted = Employee3("Ted")
    ted.age = 21
    ted.printInfo()
    val sam = Employee4("Sam", "IBM")
    sam.printCompany()
}

open class Person {
    var name = "Tom"
    var age = 32
    fun printInfo() {
        println("This is $name. He's $age years old.")
    }
}

class Employee: Person()

//А можно и так.
class Employee2: Person {
    constructor(): super()
}

open class Person2(nameIn: String) {
    val name = nameIn
    var age = 22
    fun printInfo() {
        println("This is $name. He's $age years old.")
    }
}

//Ниже пример
class Employee3: Person2 {
    constructor(empName: String): super(empName)
}

//А это пример расширения функционала базового класса.
class Employee4(name: String, val company: String): Person2(name) {
    fun printCompany() {
        println(company)
    }
}