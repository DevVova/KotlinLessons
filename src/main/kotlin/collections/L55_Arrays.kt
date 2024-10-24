package collections

/**
 * Массивы во многом аналогичны коллекциям. Массивы характеризуются постоянной длиной,
 * соответственно мы не можем динамически добавлять или удалять элементы из массива.
 * Но мы можем изменять значение уже имеющихся элементов.
 *
 * Многие общие для коллекций стандартные методы реализованы для класса Array в виде
 * функций расширения.
 *
 * Массивы представляют тип Array, который является обобщенным.
 */
fun main() {
    val arr = arrayOfNulls<Int>(6)//Создание массива из 6 элементов и изначальным значением null.
    arr.forEach { print("$it  ") }
    println()

    var i = 7
    val arr1 = Array(4) {i++ + 7}
    arr1.forEach { print("$it, ") }
    println()
    println(arr1.getOrNull(7))//Если мы не знаем сколько у массива элементов, чтобы избежать выхода за пределы массива.

    println(arr1.lastIndex)//Узнаём последний индекс.
    println(arr1.size)
    println(arr1.indices)//Узнаём диапазон индексов элементов массива.

    /*
     Для перебора вместе с индексами можно использовать функцию forEachIndexed(). Она принимает
     функцию с двумя параметрами: индексом элемента и самим элементом:
     */
    arr1.forEachIndexed { index, ii -> print("$index - $ii ; ") }
    println()

    //Пример создания многомерного массива.
    val arr2 = Array(4) {Array(7) {0} }//Создали массив и инициализировали значения всех его элементов равных 0.
    var k = 10
    //Затем в цикле изменили значения всех элементов массива.
    for (b in arr2) {
        for (c in b.indices) {
            b[c] = k
            k += 10
            print("${b[c]} ")
        }
        println()
    }
}