package collections

fun main() {
    //Минимальное и максимальное значение
    val numbers = listOf(23, 11, 83, 774, 23, 4, 12, 5)
    val bigHumans = listOf(
        BigMan("Tapir", 47),
        BigMan("Farhad", 27),
        BigMan("Bulimia", 41),
        BigMan("Kevin", 32),
        BigMan("Sam", 18),
        BigMan("Coin", 39),
    )
    /*
    Функции minOrNull() и maxOrNull() возвращают соответственно минимальное и максимальное
    значение (если коллекция/последовательность пуста, то возвращается null). Причем для
    работы этих функций элементы коллекции/последовательности должны реализовать интерфейс Comparable:
     */
    println(numbers.minOrNull())
    println(numbers.maxOrNull())
    /*
    Функции minByOrNull() и maxByOrNull() в качестве параметра принимают функцию селектора, которая
    позволяет определить критерий сравнения объектов:
     */
    println(bigHumans.minByOrNull { it.name })
    println(bigHumans.maxByOrNull { it.age })
    /*
    Выше функции находили элемент с наименьшим и наибольшим значением свойства age. Но что, если
    мы хотим получить не весь объект, а сами значения минимального и максимального возраста?
    В этом случае мы можем использовать функции minOfOrNull() и maxOfOrNull(), которые также
    принимают функцию селектора, но возвращает само значение, на основе которого происходит сравнение:
     */
    println(bigHumans.maxOfOrNull { it.name })
    println(bigHumans.minOfOrNull { it.age })
    /*
    Еще пара функций - minWithOrNull() и maxWithOrNull() в качестве параметра принимают
    компаратор - реализацию интерфейса Comparator:
     */
    println(bigHumans.minWithOrNull(compareBy { it.name.length }))
    println(bigHumans.maxWithOrNull(compareBy { it.age }))
    //Для получения среднего значения применяется функция average():
    println(numbers.average())
    //Для получения суммы числовых значений применяется функция sum():
    println(numbers.sum())

    println(numbers.count())//Для получения количества элементов в коллекции/последовательности.
    println(numbers.count { it > 77 })//Для получения количества элементов в коллекции по условию.

    /**
     * reduce принимает функцию, которая имеет два параметра. Первый параметр при первом запуске
     * представляет первый элемент, а при последующих запусках - результат функции над предыдущими
     * элементами. А второй параметр функции - следующий элемент.
     */
    val reduceNumbers = numbers.reduce {a, b ->
        a + b
    }
    println(reduceNumbers)
    /*
    Функция fold также сводит все элементы потока в один. Но в отличие от reduce в качестве
    первого параметра принимает начальное значение:
     */
    println(numbers.fold(888) {a, b -> a + b})
}

class BigMan(val name: String, val age: Int) {
    override fun toString(): String {
        return "$name($age) "
    }
}