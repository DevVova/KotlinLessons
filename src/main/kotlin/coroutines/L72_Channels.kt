package coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

//Каналы позволяют передавать потоки данных.
//Рассмотренные ниже пример по сути является распространённым способом передачи данных от одной корутины к другой.
suspend fun main() {
    coroutineScope {
        val channel = Channel<Int>()
        launch {
            for (i in 1..8) {
                channel.send(i)
            }
        }
        //Второй раз не получится запустить повторение, канал будет пустой.
        repeat(8) {//Здесь важно указать точное количество элементов в канале, иначе программа зависнет.
            val num = channel.receive()
            print("$num ")
        }
        println()

        launch {
            for (n in 77..89) {
                channel.send(n)
            }
            channel.close()
        }
        //Второй раз не получится запустить цикл, канал будет пустой.
        for (i in channel) {
            print("$i ")
        }
        println()

        //Паттерн producer-consumer.
        val allNumbers = getNumbers()
        allNumbers.consumeEach { print("$it ") }
        println()

        val numbers = listOf(99, 9, 999, 34, 2)
        getList(numbers).consumeEach { print("${it * 4}  ") }
    }
}

@OptIn(ExperimentalCoroutinesApi::class)
fun CoroutineScope.getNumbers(): ReceiveChannel<Int> {
    return produce {
        val num = listOf(23, 54, 55, 2, 33)
        for (n in num) {
            send(n)
        }
    }
}

@OptIn(ExperimentalCoroutinesApi::class)
fun <T> CoroutineScope.getList(list: List<T>): ReceiveChannel<T> = produce {
    for (n in list) {
        send(n)
    }
}