package coroutines

import kotlinx.coroutines.*

suspend fun main() {
    coroutineScope {
        val l = launch(start = CoroutineStart.LAZY) {
            try {
                println("Загрузка началась...")
                delay(1000L)
                println("Для прекращения загрузки нажмите \"Enter\" на клавиатуре...")
                for (i in 1..39) {
                    delay(700L)
                    print("$i ")
                }
                println()
            } catch (e: CancellationException) {
                println("Загрузка прервана пользователем")
            } finally {
                println("Программа завершена.")
            }
        }
        print("Нажмите на клавишу \"Enter\" чтобы начать загрузку цифр...")
        val input = readln()
        if (input == "") l.start()
        val input2 = readln()
        if (input2 == "") l.cancelAndJoin()
    }
}