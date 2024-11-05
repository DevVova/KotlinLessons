package async

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.take

suspend fun main() {
    val myFlow = listOf(34, 9, 77, 4, 21).asFlow()
    println(myFlow.count())
    myFlow.collect {
        delay(340)
        print("$it ")
    }
    println()

    /*
    Также мы можем передать в функцию count() условие в виде функции, которая
    возвращает объект Boolean, то есть true или false. Тогда функция count()
    возвратит количество элементов, которые соответствуют этому условию:
     */
    println(myFlow.count{it > 26})

    /*
    Оператор take ограничивает количество элементов в потоке. В качестве параметра
    она принимает количество элементов с начала потока, которые надо оставить в потоке:
     */
    myFlow.take(3).collect {
        delay(200)
        print("$it  ")
    }
    println()

    /*
    Оператор drop удаляет из потока определенное количество элементов. В качестве
    параметра она принимает количество элементов с начала потока, которые надо убрать из потока:
     */
    myFlow.drop(2).collect {
        delay(800)
        print("$it  ")
    }
    println()
}