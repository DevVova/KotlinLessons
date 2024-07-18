package base

fun main() {
    val range = 1..3
    for (n in range) {
        print("$n ")
    }
    println()

    //Ниже пример создания убывающего диапазона.
    val range2 = 7 downTo 3 step 2//функция step позволяет задать шаг, на который будут изменяться последующие элементы.
    for (n in range2) {
        print("$n, ")
    }
    println()

    //Ниже пример диапазона без включения элемента верхней границы.
    val range3 = 2 until 8//Но можно его и не писать, а писать "..<".
    for (n in range3) {
        print("$n, ")
    }
    println(2 !in range3)//Проверит утверждение, что 2 не входит в диапазон, если да, то вернёт true.
}