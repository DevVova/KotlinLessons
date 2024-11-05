package async

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.transform

suspend fun main() {
    val someFlow = listOf(
        Quotes2(3.45, 23),
        Quotes2(4.25, 24),
        Quotes2(3.75, 26),
        Quotes2(3.95, 27),
        Quotes2(3.05, 33),
        Quotes2(2.65, 40)
    ).asFlow()
    /*
    Оператор map() преобразует данные потока. В качестве параметра он принимает
    функцию преобразования. Функция преобразования принимает в качестве единственного
    параметра объект из потока и возвращает преобразованные данные.
     */
    someFlow.map { it.time }.collect {
        print("$it ")
        delay(400)
    }
    println()
    //Или так.
    someFlow.map {
        object {
            val price = it.price
            val maxPrice = it.price > 3.23
        }
    }.collect {
        delay(800)
        print("${it.price} is max - ${it.maxPrice}  ")
    }
    println()

    /*
    Оператор transform также позволяет выполнять преобразование объектов в потоке.
    В отличие от map она позволяет использовать функцию emit(), чтобы передавать
    в поток произвольные объекты.
     */
    someFlow.transform {
        if (it.time > 25) {
            emit(it)
        }
    }.collect {
        delay(400)
        print("$it ")
    }
    println()

    /*
    Причем при обработке одного объекта мы можем несколько раз вызывать функцию emit(),
    передавая таким образом в потоке несколько объектов:
     */
    someFlow.transform {
        if (it.price > 3.35) {
            emit(it.time)
            emit(it.price)
        }
    }.collect {
        delay(900)
        print("$it  ")//Сначала напечатает it.time, а потом it.price.
    }
    println()
}

data class Quotes2(val price: Double, val time: Int)