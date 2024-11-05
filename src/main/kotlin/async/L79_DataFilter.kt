package async

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.dropWhile
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.takeWhile

suspend fun main() {
    val peopleList = listOf(
        People("Kevin", 27),
        People("Sam", 21),
        People("Vova", 16),
        People("Ted", 24),
        People("Kolya", 54),
        People("Coin", 25),
        People("Helen", 19)
    ).asFlow()
    val newPeopleList = mutableListOf<People>()
    peopleList.filter { it.name.length > 4 }.collect {
        newPeopleList.add(it)
    }
    for (i in newPeopleList) {
        print("$i ")
    }
    println()

    //takeWhile выбирает из потока элементы, пока будет истинно некоторое условие:
    newPeopleList.clear()
    /*
    Несмотря на то, что в потоке еще есть объекты Person, которые соответствуют условию,
    но столкнувшись с первым объектом, который не соответствует условию, takeWhile
    перестает выбирать объекты в возвращаемый поток.
     */
    peopleList.takeWhile { it.age in 21..29 }.collect {
        delay(500)
        newPeopleList.add(it)
        print("${it.age} ")
    }
    println()

    /*
    Оператор dropWhile противоположен по своему действию оператору takeWhile. dropWhile
    удаляет из потока элементы, пока они не начнут соответствовать некоторому условию:
     */
    newPeopleList.clear()
    peopleList.dropWhile { it.name.length > 4 }.collect {
        newPeopleList.add(it)
    }
    for (i in newPeopleList) {
        print("$i ")
    }
    println()
}

data class People(val name: String, val age: Int)