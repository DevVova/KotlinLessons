package coroutines

import kotlinx.coroutines.*

/**
 * Все suspend-функции в пакете kotlinx.coroutines являются прерываемыми (cancellable).
 * Это значит, что они проверяют, прервана ли корутина. И если ее выполнение прервано,
 * они генерируют исключение типа CancellationException. И в самой корутине мы можем
 * перехватить это исключение, чтобы обработать отмену корутины.
 */
suspend fun main() = coroutineScope {
    val downloader = launch {
        try {
            println("Началась загрузка...")
            for (i in 1..7) {
                print("$i ")
                delay(750L)
            }
            println()
        } catch (e: CancellationException) {
            println("Загрузка прервана.")
        } finally {
            println("Загрузка завершена.")
        }
    }
    delay(1700L)
    println("Прерываем загрузку.")
    downloader.cancel()//Отменяем корутину.
    downloader.join()//Метод join() позволяет ожидать, пока корутина не завершится.
    println("Программа завершена.")
    println()

    val downloader2 = launch {
        try {
            println("Началась загрузка...")
            for (i in 1..7) {
                print("$i ")
                delay(750L)
            }
            println()
        } catch (e: CancellationException) {
            println("Загрузка прервана.")
        } finally {
            println("Загрузка завершена.")
        }
    }
    delay(2700L)
    println("Прерываем загрузку.")
    downloader2.cancelAndJoin()//Отменяем корутину и ожидаем её завершения.
    println("Программа завершена.")
    println()

    //А вот так нужно прерывать async-корутины.
    val downloader3 = async {
        delay(300L)
        println("Снова началась загрузка...")
    }
    downloader3.cancelAndJoin()
    try {
        println("Прерываем загрузку")
        downloader3.await()
    } catch (e: CancellationException) {
        println("Снова прервана загрузка")
    } finally {
        println("Программа завершила своё действие.")
    }
}