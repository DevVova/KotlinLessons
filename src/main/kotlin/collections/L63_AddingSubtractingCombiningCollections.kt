package collections

fun main() {
    val n34 = listOf(34, 23, 2, 12, 54, 57, 8, 39)
    val numbers2 = listOf(33, 22, 11)
    /*
    С помощью функции plus можно складывать коллекции/последовательности с другими
    элементами или коллекциями/последовательностями. Данная функция принимает как
    одиночный элемент, так и коллекцию/последовательность:
     */
    println(n34.plus(235))
    println(n34 + 345)//Или так.
    println(n34.plus(numbers2))

    //Вычитание.
    println(n34.minus(23))

    //Для объединения двух разных коллекций/последовательностей в одну применяется функция zip():
    println(n34.zip(numbers2))//В качестве параметра она принимает другую коллекцию/последовательность и возвращает набор из объектов типа Pair.
    val numbersString = listOf("one", "two", "three")
    val zipNumbers2 = numbersString.zip(numbers2)
    println(zipNumbers2)
    println(zipNumbers2[1].first)//Напечатает первый элемент пары, элемента с индексом 1.
}