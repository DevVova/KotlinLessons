package coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.coroutineScope

//Здесь реализовано принятие чисел одного списка и преобразование в другой список, где элементы идут наоборот.
suspend fun main() {
    coroutineScope {
        val num1 = listOf(1, 2, 3, 4, 5, 6)
        opposite(num1).consumeEach { print("$it ") }
    }
}

@OptIn(ExperimentalCoroutinesApi::class)
fun <T>CoroutineScope.opposite(list: List<T>): ReceiveChannel<T> = produce {
    val listNew = list.reversed()
    listNew.forEach{ send(it) }
}