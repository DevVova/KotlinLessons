package functions

/**
 * Функции высокого порядка (high order function) - это функции, которые либо принимают
 * функцию в качестве параметра, либо возвращают функцию, либо и то, и другое.
 */

fun main() {
    print("Введите первое число: ")
    val num1 = readln().toInt()
    print("Введите второе число: ")
    val num2 = readln().toInt()
    print("Нажмите 1 если хотите сложить два этих числа\n" +
            "Нажмите 2, если хотите из первого числа вычесть второе\n" +
            "Нажмите 3 если хотите эти числа перемножить.\n: ")
    val variant = readln().toInt()
    when (variant) {
        1 -> operation2(num1, num2, ::sum3)
        2 -> operation2(num1, num2, ::subtract3)
        3 -> operation2(num1, num2, ::multiply)
        else -> println("Вы ввели неверное число, нужно было 1, 2 или 3.")
    }

    val action1 = selectAction(1)
    println(action1(107, 56))
    val action2 = selectAction(3)
    println(action2(107, 563))
}

fun operation2(a: Int, b: Int, op: (Int, Int) -> Int): Int {
    val result = op(a, b)
    println(result)
    return result
}

fun sum3(a: Int, b: Int): Int = run {a + b}

fun subtract3(a: Int, b: Int) = a - b

fun multiply(a: Int, b: Int) = a * b

fun empty(a: Int, b: Int): Int {
    return 0
}

fun selectAction(key: Int): (Int, Int) -> Int {
    return when(key) {
        1 -> ::sum3
        2 -> ::subtract3
        3 -> ::multiply
        else -> ::empty
    }
}