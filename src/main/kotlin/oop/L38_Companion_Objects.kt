package oop

/**
 * Класс в языке Kotlin может содержать так называемые companion-объекты.
 * Companion-объект определяется внутри некоторого класса и позволяет определить
 * свойства и методы, которые будут общими для всех объектов этого класса.
 * В ряде языков программирования есть похожая концепция - статические поля/свойства и методы.
 * То есть companion-объекты определяют свойства и методы класса в целом, а не объекта.
 */
fun main() {
    val h1 = Home()
    h1.countInfo()
    val h2 = Home()
    h2.countInfo()
    println()

    //Для обращения к свойствам компаньона объекта нужно указывать название класса.
    println(Home.count)
    Home.resetCount()
    println()
    println(Home.count)
    println()

    //Пример использования класса унаследованного от другого.
    val m1 = MyHome()
    m1.countInfo()
    Home.resetCount()
    m1.countInfo()
}

open class Home {
    init {
        count++
    }
    companion object{
        var count = 0
        fun resetCount() {
            count = 0
        }
    }
    fun countInfo() {
        println(count)
    }
}

/**
 * Методы и свойства companion-объекта не наследуются, поэтому для обращения к ним
 * применяется имя базового класса, в котором определен companion-объект.
 */
class MyHome : Home()