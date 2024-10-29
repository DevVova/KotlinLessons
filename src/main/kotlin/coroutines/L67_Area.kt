package coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Корутина может выполняться только в определенной области корутины (coroutine scope).
 * Область корутин представляет пространство, в рамках которого действуют корутины,
 * она имеет определенный жизненный цикл и сама управляет жизненным циклом создаваемых
 * внутри нее корутин.
 *
 * И для создания области корутин в Kotlin может использоваться ряд функций, которые
 * создают объект интерфейса CoroutineScope. Одной из функций является coroutineScope.
 */
suspend fun main() {
    asincWork()
    println("Hello!")
    nestedCoroutines()
}

suspend fun asincWork() {
    coroutineScope {
        blockingWork()//Функция runBlocking блокирует вызывающий поток.
        launch {
            for (i in 77..83) {
                print("$i   ")
                delay(700L)
            }
        }
        println("Hello!")
    }
}

/**
 * Функция runBlocking блокирует вызывающий поток, пока все корутины внутри вызова
 * runBlocking {... } не завершат свое выполнение. В этом собственно основное отличие
 * runBlocking от coroutineScope: coroutineScope не блокирует вызывающий поток, а
 * просто приостанавливает выполнение, освобождая поток для использования другими ресурсами.
 */
suspend fun blockingWork() = runBlocking {
    launch {
        for (i in 0..7) {
            print("$i ")
            delay(300L)
        }
        println("Blocking is stop!")
    }
}

/**
 * И подобным образом внешние корутины определяют область для вложенных корутин и управляют их жизненным циклом.
 */
suspend fun nestedCoroutines() {
    coroutineScope {
        launch {
            delay(2000L)
            println("Outer coroutine.")

            //Одна корутина может содержать другие корутины.
            launch {
                println("Inner coroutine.")
            }
        }
        println("The end!")
    }
}