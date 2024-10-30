package coroutines

import kotlinx.coroutines.*

suspend fun main() = coroutineScope {
    print("Введите своё имя: ")
    val yourName = readln()
    val a = async(start = CoroutineStart.LAZY) {
        work(yourName)
    }
    delay(1000L)
    println()
    print("Если хотите продолжить, нажмите \"Enter\", а если хотите прервать выполнение, то любую другую клавишу и \"Enter\".")
    val input = readln()
    if (input == "") {
        a.start()
        println("Вас зовут ${a.await()}. Hello ${a.await()}!")
    } else {
        a.cancelAndJoin()
        try {
            print("Программа прервана...")
            println()
        } catch (e: CancellationException) {
            println("Завершаем работу программы")
        } finally {
            println("Работа программы завершена!")
        }
    }
}

fun work(name: String): String {
    return name
}