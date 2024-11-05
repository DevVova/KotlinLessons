package async

import kotlinx.coroutines.flow.*

suspend fun main() {
    val newFlow = listOf(3, 21, 11, 50, 84).asFlow()
    val newFlow2 = mutableListOf<Int>().asFlow()

    //Метод first() получает первый объект списка:
    println(newFlow.first())
    /*
    Также метод first() может в качестве параметра принимать функцию-условие, которая
    возвращает объект Boolean. Тогда first() возвращает первый элемент потока,
    который соответствует этому условию:
     */
    println(newFlow.first { it > 40 })
    //Но лучше не рисковать и использовать firstOrNull, а то вдруг поток пуст или нет элемента по условию.
    println(newFlow.firstOrNull { it < 0 })

    //last / lastOrNull.
    println(newFlow.lastOrNull())

    /*
    Функция single() возвращает единственный элемент потока, если поток содержит только
    один элемент. Если поток не содержит элементов, генерируется исключение
    NoSuchElementException, а если в потоке больше одного элемента - исключение IllegalStateException.
     */
    try {
        println(newFlow2.single())
    } catch (e: Exception) {
        println(e.message)
    }

    try {
        println(newFlow.single())
    } catch (e: Exception) {
        println(e.message)
    }

    //Поэтому лучше так.
    println(newFlow.singleOrNull())
}