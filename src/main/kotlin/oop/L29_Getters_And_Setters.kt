package oop

//Геттеры (getter) и сеттеры (setter) (еще их называют методами доступа) позволяют управлять доступом к переменной.
//Геттеры и сеттеры необязательно определять именно для свойств внутри класса, они могут также применяться к переменным верхнего уровня.
var nameUp: String = "Ann"
    //Сеттер определяет логику установки значения переменной. Он определяется с помощью слова set.
    set(value) {
        if (value == "Vova" || value == "Ann") {
            field = value
        } else field = "Fuck"
    }
val thisName: String
    //Геттер управляет получением значения свойства и определяется с помощью ключевого слова get.
    get() = "hey"

fun main() {
    nameUp = "Helen"
    println(nameUp)
    nameUp = "Vova"
    println(nameUp)
    println(thisName)

    val max = Person2222("Max", "True", 21)
    max.printInfo()
    max.age = 122
    max.printInfo()
}

open class Person2222(private val firstName: String, private val lastName: String, ageIn: Int) {
    //set не может быть так как переменная val.
    protected val fullName
        get() = "$firstName $lastName"
    var age = ageIn
        set(value) {
            if (value in 1..120) field = value
            else {
                println("Are you crazy?")
                field = 66
            }
        }
        get() {
            println("Call get function.")
            return if (field == 99) 99 else field
        }
    fun printInfo() {
        println("Meet $fullName. Her first name is $firstName. Her last name is $lastName. He's $age years old.")
    }
}