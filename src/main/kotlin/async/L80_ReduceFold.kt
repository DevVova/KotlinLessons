package async

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.fold
import kotlinx.coroutines.flow.reduce

suspend fun main() {
    var i = 1
    val numList = MutableList(5) {i++}.asFlow()
    /*
    reduce принимает функцию, которая имеет два параметра. Первый параметр при
    первом запуске представляет первый объект потока, а при последующих
    запусках - результат функции над предыдущими объектами. А второй параметр
    функции - следующий объект.
     */
    val reduceList = numList.reduce {a, b ->
        a * b
    }
    println(reduceList)
    /*
    Функция fold также сводит все элементы потока в один. Но в отличие от оператора
    reduce оператор fold в качестве первого параметра принимает начальное значение:
     */
    val foldList = numList.fold(10) {a, b ->
        a + b
    }
    println(foldList)
}