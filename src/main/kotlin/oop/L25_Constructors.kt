package oop

/**
 * Для создания объекта необходимо вызвать конструктор класса. По умолчанию компилятор
 * создает конструктор, который не принимает параметров, и который мы можем использовать.
 * Но также мы можем определять свои собственные конструкторы. Классы в Kotlin могут
 * иметь один первичный конструктор (primary constructor) и один или несколько вторичных
 * конструкторов (secondary constructor).
 */
fun main() {
    val ship = Toy(22000, "ship")
    ship.info()
    val ship2 = Toy3(1200)//С пустыми скобками нельзя, так как есть вторичные конструкторы.
    ship2.name = "ship2"
    val ship3 = Toy2(11)
    ship3.price = 3499
    val ship5 = Toy5(1000, "fly")
    ship5.info()
    val vova = Man1978()
    vova.age = 46
}

class Toy {
    var price = 34
    var name = "car"
    constructor(priceIn: Int) {
        price = priceIn
    }
    constructor(priceInTwo: Int, nameIn: String) : this(priceInTwo) {
        name = nameIn
    }
    fun info() {
        println("This is a $name. Its price is $price.")
    }
}

class Toy2(priceIn: Int) {
    var price: Int
    var name: String = "car"

    //Ниже блок инициализатора. У класса их может быть несколько.
    init {
        price = priceIn
    }
    //Пытался конструктор снизу написать без this, но среда не даёт и ругается.
    //Если для класса определен первичный конструктор, то вторичный конструктор должен вызывать первичный с помощью ключевого слова this.
    constructor(priceInTwo: Int, nameInTwo: String) : this(priceInTwo) {
        name = nameInTwo
    }
}

class Toy3 {
    var price: Int
    var name: String = "car"
    constructor(priceIn: Int) {
        price = priceIn
    }
    //Вот как писать без this.
    constructor(priceInTwo: Int, nameInTwo: String) {
        price = priceInTwo
        name = nameInTwo
    }
}

//Первичный конструктор также может использоваться для определения свойств.
class Toy5(private val price: Int, private val name: String) {
    fun info() {
        println("This is a $name. Its price is $price.")
    }
}

//Вот как можно с пустым конструктором потом использовать класс.
class Man1978() {
    var age: Int = 46
    var name = "Tom"
    constructor(ageIn: Int) : this () {
        age = ageIn
    }
}