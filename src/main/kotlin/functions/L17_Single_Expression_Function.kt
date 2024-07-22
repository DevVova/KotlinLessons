package functions

/**
 * Однострочные функции (single expression function) используют сокращенный синтаксис
 * определения функции в виде одного выражения. Эта форма позволяет опустить возвращаемый
 * тип и оператор return.
 */
fun main() {
    fun add(a: Int, b: Int) = a + b
    val res = add(22, 11)
    println(res)
    add2(33, 2)

    print("Введите ваш возраст: ")
    val inputAge = readln().toInt()
    printAge(inputAge)
}

//Если нужно выполнить не одно действие, то можно вот так.
fun add2(a: Int, b: Int) = run {
    val res = a + b
    println(res)
    res
}

//Локальные функции.
fun printAge(age: Int) {
    //Ниже функция, которая вложена в другую функцию, это так называемая локальная функция.
    fun validAge(age2: Int) = age2 in 1..119
    if (validAge(age)) println("Вам $age лет.") else println("Возраст указан не корректно.")
}