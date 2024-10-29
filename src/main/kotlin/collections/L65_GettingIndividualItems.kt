package collections

fun main() {
    val numbers = listOf(3, 22, 45, 2, 22, 45, 67, 66, 49, 10, 3575)
    //Для получения элемента по индексу применяется функция elementAt(), в которую передается индекс элемента:
    println(numbers.elementAt(2))
    //Но лучше использовать функцию elementAtOrNull(), которая возвращает null, если индекс вне границ:
    println(numbers.elementAtOrNull(34))
    //Также в этом случае можно использовать функцию elementAtOrElse():
    println(numbers.elementAtOrElse(45) { 888 })

    /*
    Если надо получить первый или последний элементы коллекции/последовательности,
    то можно использовать соответственно функции first() и last():
     */
    println(numbers.first())
    println(numbers.last())
    //В качестве параметра эти функции могут принимать функцию предиката.
    println(numbers.first { it >= 48 })
    /*
    Однако если коллекция пуста, или в коллекции/последовательности нет элементов,
    которые соответствуют условию, то программа генерирует ошибку. В этом случае
    можно применять функции firstOrNull() и lastOrNull(), которые возвращают null,
    если коллекция пуста или в ней нет элементов, соответствующих условию:
     */
    println(numbers.firstOrNull { it == 9 })

    //Для извлечения случайного элемента применяется функция random().
    println(numbers.random())
    /*
    Однако если коллекция/последовательность пуста, то эта функция генерирует
    ошибку. В этом случае можно использовать функцию randomOrNull(),
    которая в этом случае возвращает null:
     */
    val n: List<Int> = listOf()
    println(n.randomOrNull())
}