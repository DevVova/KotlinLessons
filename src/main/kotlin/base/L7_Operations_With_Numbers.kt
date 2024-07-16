package base

fun main() {
    val a1 = 7
    val a2 = 8
    var a3 = a1 + a2

    //Простые арифметические операции.

    println(a3)
    a3 = a1 - a2
    println(a3)
    a3 = a1 * a2
    println(a3)
    a3 = (a1 + 999) / a2
    println(a3)
    a3 = (a1 + 999) % a2
    println(a3)

    //Также есть ряд операций присвоения, которые сочетают арифметические операции и присвоение.

    a3 /= 2//Присваивание после деления. Присваивает левому операнду частное левого и правого операндов.
    println(a3)
    a3 += 207//Присваивание после сложения. Присваивает левому операнду сумму левого и правого операндов.
    println(a3)
    a3 -= 200//Присваивание после вычитания. Присваивает левому операнду разность левого и правого операндов.
    println(a3)
    a3 *= 20//Присваивание после умножения. Присваивает левому операнду произведение левого и правого операндов.
    println(a3)
    a3 %= 21//Присваивание после деления по модулю. Присваивает левому операнду остаток от целочисленного деления левого операнда на правый.
    println(a3)

    //Инкремент.

    //Префиксный инкремент возвращает увеличенное значение:
    var x = 5
    var y = ++x
    println(x)      // x = 6
    println(y)      // y = 6
    println()

    //Постфиксный инкремент возвращает значение до увеличения на единицу:
    x = 5
    y = x++
    println(x)      // x = 6
    println(y)      // y = 5
    println()

    //Декремент.

    //Префиксный декремент возвращает уменьшенное значение:
    x = 5
    y = --x
    println(x)      // x = 4
    println(y)      // y = 4
    println()

    //Постфиксный декремент возвращает значение до уменьшения на единицу:
    x = 5
    y = x--
    println(x)      // x = 4
    println(y)      // y = 5
    println()

    //Поразрядные операции не рассматриваю, так как не собираюсь их использовать.
}