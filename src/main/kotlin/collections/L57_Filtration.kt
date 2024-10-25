package collections

fun main() {
    val sequenceNew = sequenceOf(
        Quotes(1672515782136, 23),
        Quotes(1672515000036, 38),
        Quotes(1672225000036, 28),
        Quotes(1671225000036, 27),
    )
    var myList = sequenceNew.filter { it.time in 1672225000036..1672515000036 }.toList()
    println(myList)

    //Еще одна функция - filterIndexed() также получает индекс текущего элемента:
    myList = sequenceNew.filterIndexed { index, i ->
        (index in 1..3) && (i.time >= 1671225000036)
    }.toList()
    println(myList)

    //С помощью функции filterIsInstance() можно извлечь элементы определенного типа.
    val list1 = listOf(Car(29), Car(21), null, SuperCar(45), null, Car(32), SuperCar(87))
    val list2 = list1.filterIsInstance<SuperCar>()
    println(list2.joinToString())

    //Функция filterNotNull() позволяет выфильтровать все значение, которые равны null:
    val list3 = list1.filterNotNull()
    println(list3.joinToString())
}

data class Quotes(val time: Long, val price: Int)

open class Car(val price: Int)

class SuperCar(priceCar: Int) : Car(priceCar) {
    override fun toString(): String {
        return "SuperCar($price)"
    }
}