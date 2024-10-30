package coroutines

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

/**
 * Наряду с launch в пакете kotlinx.coroutines есть еще один построитель
 * корутин - функция async. Эта функция применяется, когда надо получить
 * из корутины некоторый результат.
 *
 * async-корутина возвращает объект Deferred, который ожидает получения результата
 * корутины. (Интерфейс Deferred унаследован от интерфейса Job, поэтому для также
 * доступны весь функционал, определенный для интерфейса Job)
 *
 * Для получения результата из объекта Deferred применяется функция await().
 */
suspend fun main() {
    coroutineScope {
        //Эти функции запускаются параллельно. То есть их можно где-то запустить и далее выполнять основной код.
        val deferred = async {
            sum(23, 45)
        }
        val deferred2 = async { sum(44, 88) }
        val deferred3 = async { sum(4, 78) }
        val deferred4 = async { sum(64, 188) }
        println("Hello")
        //А затем мы ждём получения всех результатов.
        println(deferred.await())
        println(deferred2.await())
        println(deferred3.await())
        println(deferred4.await())
        println("Bye!")
        println()

                                //Отложенный запуск
        val deferredStart = async(start = CoroutineStart.LAZY) { sum(6868, 333) }
        val deferredStart2 = async(start = CoroutineStart.LAZY) { sum(658, 9993) }
        println("Hello")
        println(deferred.await())
        println(deferredStart.await())//Запуск и выполнение корутины только здесь, а не выше.
        println("Bye!")

        //Но можно запустить корутину и раньше, а получить результат позже, например:
        println()
        deferredStart.start()
        deferredStart2.start()
        Thread.sleep(1200)
        //Всё что ниже напечатается сразу.
        println("Hello")
        println(deferredStart.await())
        println(deferredStart2.await())
        println("Bye!")

        //А вот пример ниже когда напечатается не сразу, несмотря на остановку потока основного.
        val deferredStart3 = async(start = CoroutineStart.LAZY) { sum(6868, 333) }
        val deferredStart4 = async(start = CoroutineStart.LAZY) { sum(658, 9993) }
        println()
        println("Hello")
        Thread.sleep(1200)
        println(deferredStart3.await())
        println(deferredStart4.await())
        println("Bye!")
    }
}

suspend fun sum(a: Int, b: Int): Int {
    delay(1200L)
    return a + b
}