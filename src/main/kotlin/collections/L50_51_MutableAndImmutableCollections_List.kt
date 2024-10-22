package collections

/**
 * Коллекции представляют контейнеры, которые используются для хранения данных.
 * В зависимости от типа коллекции различаются способы работы с данными.
 *
 * Kotlin не имеет собственной библиотеки коллекций и полностью полагается на
 * классы коллекций, которые предоставляет Java. В то же время эти коллекции
 * в Kotlin расширяются дополнительными возможностями.
 *
 * Так, в Kotlin коллекции разделяются на изменяемые (mutable) и неизменяемые
 * (immutable) коллекции.
 *
 * Mutable-коллекция может изменяться, в нее можно добавлять, в ней можно изменять,
 * удалять элементы. Immutable-коллекция также поддерживает добавление, замену и
 * удаление данных, однако в процессе подобных операций коллекция будет заново пересоздаваться.
 *
 * List представляет последовательный список элементов. При этом List представляет
 * неизменяемую (immutable) коллекцию, которая в основном только обеспечивает получение
 * элементов по позиции.
 *
 * Интерфейс List расширяет интерфейс Collection, поэтому перенимает его возможности.
 *
 * Для создания объекта List применяется метод listOf().
 */
fun main() {
    val myList = listOf(23, 12, 11, 38, 22, 8, 0, 3)
    println(myList[1])
    val a = myList.getOrNull(4)//Чтобы при выходе за границы не обрабатывать исключение.
    println(a)
    val aa = myList.getOrElse(8) { 999 }//Это альтернатива getOrNull, только в случае выхода за границы aa = 999.
    println(aa)
    println(myList.size)//Напечатает количество элементов.
    println(myList.contains(44))//Напечатает true, если коллекция содержит элемент = 44.
    val newList = listOf(23, 12)
    println(myList.containsAll(newList))//Напечатает true, если коллекция содержит newList.
    println(myList.all { it % 2 == 0 })//Возвращает true, если все элементы соответствуют предикату, то есть все числа чётные.
    println(myList.any { it == 12})////Возвращает true, если хоть какой-то элемент соответствуют предикату.

    //Ниже мы преобразовали myList в список, затем отфильтровали чётные числа, умножили их на 3 и снова преобразовали в список.
    val superMyList = myList.asSequence().filter { it % 2 == 0 }.map { it * 3 }.toList()
    for (i in superMyList) {
        print("$i  ")
    }
    println()

    println(myList.average())//Получаем среднее значение для числовой коллекции типов Byte, Int, Short, Long, Float, Double.

    //Расщепление коллекции на список.
    //Разбиваем список на подсписки размером по 3 элемента
    val chunkList = myList.chunked(3)
    println(chunkList)
    //Разбиваем список на подсписки и преобразуем каждый в сумму его элементов.
    val chunkList2 = myList.chunked(2) { chunk ->
        chunk.sum()//Возвращает сумму элементов коллекции.
    }
    println(chunkList2)

    //Получение части списка.
    val subList = myList.subList(3, 5)//Получаем подсписок с элементами с индексами от 3 до 5(не включая 5).
    println(subList)

    //А вот так можно добавлять и удалять элементы в неизменяемый список.
    val someList = listOf(2, 56, 34, 8, 22)
    var nList = someList.plus(77)
    println(nList)
    nList = someList.minus(8)
    println(nList)
    println()


                                          //Изменяемые списки.
    val anyList = mutableListOf(3, 2, 13)
    anyList.add(1, 34)//Всовывает в список на место с индексом 1 новый элемент, остальные сдвигает.
    println(anyList)
    anyList.addLast(23)//Добавили в конец 23.
    anyList.addFirst(78)//Добавили в начало списка 78.
    println(anyList)
    val nextList = mutableListOf(233, 4)
    anyList.addAll(nextList)
    println(anyList)
    anyList.removeAt(2)//Удаляет из списка элемент с индексом 2.
    anyList.remove(78)//Удаляет из списка элемент со значением 78.
    println(anyList)
    nextList.clear()//Очищает весь список.
    println(nextList)

                                  //Сортировка коллекций.
    //sorted() — сортировка по возрастанию:
    val sortedList = anyList.sorted()
    println(sortedList)
    //sortedBy(selector: (T) -> R?) — сортировка по возрастанию на основе селектора:
    val humanList = mutableListOf(Human(34, "Ted"), Human (78, "Kolya"), Human(12, "Max"))
    val sortedHumanList = humanList.sortedBy { it.age }// Сортируем по возрасту.
    println(sortedHumanList)
    //sortedDescending() — сортировка по убыванию:
    val sortedList2 = anyList.sortedDescending()
    println(sortedList2)
    //sortedByDescending(selector: (T) -> R?) — сортировка по убыванию на основе селектора:
    val sortedHumanList2 = humanList.sortedByDescending { it.name }
    println(sortedHumanList2)
    val sortedHumanList3 = humanList.minOf { it.age }
    println(sortedHumanList3)//Находим минимальный возраст.
    val sortedHumanList4 = humanList.maxOfOrNull { it.age }
    println(sortedHumanList4)//Находим максимальный возраст. Если коллекция пуста, то возвращает null.
}

data class Human(val age: Int, val name: String)