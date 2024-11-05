package async

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.zip

suspend fun main() {
    //Оператор zip позволяет объединить два потока данных:
    /*
    Оператор zip принимает два параметра. Первый параметр - поток данных,
    с которым надо выполнить объединение. Второй параметр - собственно функция
    объединения. Она принимает соответствующие элементы обоих потоков в качестве
    параметров и возвращает результат их объединения.
     */
    val english = listOf("one", "two", "three").asFlow()
    val russian = listOf("один", "два", "три").asFlow()
    val dictionary = mutableListOf<String>()
    english.zip(russian) {a, b ->
        "$a - $b "
    }.collect {dictionary.add(it)}
    for (i in dictionary) {
        delay(500)
        print("$i ")
    }
    println()

    val value = listOf(1, 2, 3).asFlow()
    val englishNumber = mutableListOf<EnglishNumber>()
    value.zip(english) {a, b ->
        EnglishNumber(b, a)
    }.collect {
        englishNumber.add(it)
    }
    for (n in englishNumber) {
        delay(700)
        print("$n ")
    }
}

data class EnglishNumber(val name: String, val value: Int)