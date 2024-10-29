package collections

fun main() {
    val people = listOf("Vova", "Kolya", "Ann", "Bolivar", "Sam", "Coin", "Kevin", "Tom")
    //Функция slice() возвращает часть коллекции, элементы которой располагаются на определенных индексах.
    //Стоит отметить, что для последовательностей эта функция не доступна.
    println(people.slice(1..3))
    println(people.slice(1..5 step 2))
    println(people.slice(listOf(0, 3, 4)))

    //Функция take() извлекает из начала коллекции/последовательности определенное количество элементов.
    println(people.take(4))
    //Функция takeLast(), которая извлекает определенное количество элементов из конца коллекции.
    println(people.takeLast(3))

    //Функция takeWhile() отбирает элементы с начала коллекции/последовательности, которые соответствуют условию предиката:
    println(people.takeWhile { it.length == 4 })//Когда встретится хоть один элемент, который не соответствует условию, она завершит работу.
    //Функция takeLastWhile() работает аналогичным образом, только выбирает элементы с конца списка.
    println(people.takeLastWhile { it.length == 5 })

    //Функция drop() позволяет пропустить определенное количество элементов в коллекции/последовательности:
    println(people.drop(1))
    //Функция dropLast(), которая пропускает определенное количество элементов из конца коллекции:
    println(people.dropLast(3))
    //Функция dropWhile() пропускает элементы с начала коллекции/последовательности, которые соответствуют условию предиката:
    println(people.dropWhile { it.length == 4 })
    /*
    Для коллекций также доступа функция dropLastWhile(), которая работает аналогичным образом,
    только пропускает элементы с конца списка.
     */
    println(people.dropLastWhile { it == "Tom" })

    //Функция chunked() позволяет разбить коллекцию/последовательность на списки определенной длины:
    val parts = people.chunked(3)
    println(parts)
    //Дополнительная версия функции в качестве второго параметра принимает функцию преобразования элементов:
    println(people.chunked(3) { it[1]})
}