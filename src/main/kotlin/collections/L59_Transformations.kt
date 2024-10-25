package collections

/**
 * Для трансформации одной коллекции/последовательности применяется функция map().
 * В качестве параметра она принимает функцию преобразования. Функция преобразования
 * получает текущий элемент коллекции/последовательности и возвращает результат
 * преобразования. Причем типа входных и выходных данных могут совпадать, а могут и отличаться.
 */
fun main() {
    val quotes = listOf(
        Quotes2(1671225000036, 2.34),
        Quotes2(1671225023436, 2.37),
        Quotes2(1671225040036, 2.44),
        Quotes2(1671225500036, 2.24),
        Quotes2(1671226700036, 2.0)
    )
    val price = quotes.map { it.price }
    println(price)

    //Еще одна функция - mapIndexed() также передает в функцию преобразования индекс текущего элемента:
    val infoPrice = quotes.mapIndexed {index, i ->
        "Элемент$index равен ${i.price}   "
    }
    println(infoPrice)

    /*
    Если необходимо отсеять значения null, которые могут возникать при преобразовании, то можно применять
    аналоги выше упомянутых функций - mapNotNull() и mapIndexedNotNull():
     */
    val notNullList = quotes.mapNotNull { if (it.price == 2.44) null else it.price }
    println(notNullList)
    val notNullList2 = quotes.mapIndexedNotNull { index, i ->
        if (index == 2 || i.price == 2.34) null else i.time}
    println(notNullList2)

    //Функция flatten() позволяет преобразовать коллекцию/последовательность, которая содержит вложенные коллекции/последовательности:
    val allNumbers = listOf(listOf(34, 2, 12), listOf(22, 8, 66), listOf(- 9, 8))
    val nn = allNumbers.flatten()
    println(nn)
}

data class Quotes2(val time: Long, val price: Double)