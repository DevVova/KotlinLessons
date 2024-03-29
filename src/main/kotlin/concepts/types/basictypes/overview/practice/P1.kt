package concepts.types.basictypes.overview.practice

fun main() {
    val aa = 2
    println(aa.dec())//Возвратит уменьшенное число 2, dec это метод класса Int(или иначе говоря функция-член).
    val r = Short.MAX_VALUE
    println(r)//Возвратится максимальное значение для класса Short. MAX_VALUE- это компаньон объект.

    /**
     * Ниже можно увидеть пример создания двух переменных, одна из которых имеет базовый тип, а
     * другая пользовательский тип. У одной мы конструктор не вызываем при создании, а просто
     * пишем целочисленный литерал, а у другой нам нужно вызвать конструктор, то есть функцию,
     * в результате которой будет создан экземпляр этого класса. И у этих обоих объектов, как и у
     * всех типов в Kotlin есть встроенные методы, унаследованные от класса Any.
     */
    val num: Byte = -8
    val sam = Human()
    println(num.toString())
    println(sam.toString())
}

class Human {
    val age = 4
}