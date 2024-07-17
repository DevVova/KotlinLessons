package base

/**
 * Конструкция when проверяет значение некоторого объекта и в зависимости от его значения выполняет
 * тот или иной код. Конструкция when аналогична конструкции switch в других языках.
 */
fun main() {
    val a = 23
    val b = 7
    when (b) {
        in 2..4 -> println("b in range from 2 to 4")
        in 2..6 -> println("b in range from 2 to 8")
        else -> println("b is not range from ...")
    }
    //Ниже пример того как when является выражением.
    val c = when {
        a < 5 -> a + b
        a >= 5 -> {
            a - b
            //println("c = ${a - b}")//Если это оставить, то с будет Any. Я здесь показал что можно использовать блоки, если действий несколько.
        }
        else -> a * 4
    }
    println(c)
}