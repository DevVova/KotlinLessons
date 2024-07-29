package oop

/**
 * Абстрактные классы - это классы, определенные с модификатором abstract. Отличительной
 * особенностью абстрактных классов является то, что мы не можем создать объект подобного класса.
 * Абстрактный класс, как и обычный, может иметь свойства, функции, конструкторы, но создать
 * его объект напрямую вызвав его конструктор мы не можем. Такой класс мы можем только унаследовать.
 *
 * Абстрактные методы не содержат реализацию, то есть у них нет тела. А для абстрактных свойств
 * не указывается значение. При этом абстрактные методы и свойства можно определить только
 * в абстрактных классах.
 */
fun main() {
    val cube = Cube(color = "grey")
    cube.info()
    println(cube.price)
}

abstract class Figure(open val price: Int) {
    abstract var color: String

    abstract fun info()
}

class Cube(override val price: Int = 1400, override var color: String = "blue"): Figure(price) {

    override fun info() {
        println("Its color is $color.")
    }
}