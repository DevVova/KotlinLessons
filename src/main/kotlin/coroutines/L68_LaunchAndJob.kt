package coroutines

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() = coroutineScope {
    //Построитель корутин launch возвращает объект Job, с помощью которого можно управлять запущенной корутиной:
    val job = launch {
        for (i in 1..5) {
            println(i)
        }
        delay(400L)
    }
    println("Start")
    job.join()//Метод join() позволяет ожидать, пока корутина не завершится.
    println("Finish")
    println()

                              //Отложенное выполнение
    /*
    По умолчанию построитель корутин launch создает и сразу же запускает корутину.
    Однако Kotlin также позволяет применять технику отложенного запуска корутины (lazy-запуск),
    при котором корутина запускается при вызове метода start() объекта Job.

    Для установки отложенного запуска в функцию launch() передается значение start = CoroutineStart.LAZY.
     */
    val job2 = launch(start = CoroutineStart.LAZY) {
        for (i in 33..38) {
            delay(1000)
            print("$i ")
        }
        println("All be finish.")
    }
    println("Start")
    job2.start()//Здесь мы увидим отложенное выполнение корутины.
    println("Finish")
}