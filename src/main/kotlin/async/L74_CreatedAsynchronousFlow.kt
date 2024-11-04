package async

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf

suspend fun main() {
    val listN = listOf(2, 1, 11, 34, 55)
    val newList = mutableListOf<Int>()
    val newNum = getNewNumbers(listN)
    newNum.collect {
        newList.add(it)
        print("$it ")
    }
    println("\n")

    //Или так можно короче.
    newList.clear()
    val newNum2 = flow {
        for (i in listN) {
            delay(300)
            emit(i)
        }
    }
    newNum2.collect {
        newList.add(it)
        print("$it  ")
    }
    println("\n")

    //Функция flowOf.
    val newNum3 = flowOf(45, 89, 90, 33)
    newNum3.collect {
        delay(400)
        newList.add(it)
        print("$it ")
    }
    println("\n")

    //Метод asFlow.
    listN.asFlow().collect { delay(500); print("$it ")}; println()
}

fun getNewNumbers(list: List<Int>): Flow<Int> {
    return flow {
        for (i in list) {
            delay(200)
            emit(i * i)
        }
    }
}