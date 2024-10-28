package collections

/**
 * По умолчанию процесс сортировки опирается на реализацию интерфейса Comparable,
 * которая определяет, какой объект будет больше, а какой меньше. Так, для
 * встроенных базовых типов действует следующая логика:
 *
 * Числа сравниваются как в математике исходя из их значения.
 *
 * Символы (Char) и строки (String) сравниваются исходя из лексикографического
 * порядка, то есть "Tom" больше, чем "Alice", потому что первый символ - T
 * располагается в алфавите после символа A.
 *
 * Если мы определяем свои типы и хотим, чтобы их объекты также можно было
 * отсортировать, то в этом случае следует реализовать интерфейс Comparable.
 */
fun main() {
    val runners = listOf(
        Runner(15, "Max"),
        Runner(25, "Ted"),
        Runner(45, "Vova"),
        Runner(24, "Sam"),
        Runner(17, "Coin"),
        Runner(33, "Fill"),
        )
    println(runners.sorted())
    println(runners.sortedDescending())


                        //sortedWith и интерфейс Comparator
    /**
     * Бывает, что нам недоступен код классов, объекты которых мы хотим отсортировать.
     * Либо мы хотим задать для уже существующих типов, которые уже реализуют Comparable,
     * другой способ сортировки. В этом случае мы можем использовать интерфейс Comparator.
     *
     * Kotlin имеет встроенную функцию sortedWith(), которая в качестве параметра
     * принимает компаратор и на его основе сортирует коллекцию/последовательность.
     */
    val s = runners.sortedWith { a: Runner, b: Runner ->
        a.age - b.age
    }
    println(s)

    //А можно и ещё короче.
    val ss = runners.sortedWith(compareBy { it.name.length })
    println(ss)


                     //Сортировка на основе критерия.
    println(runners.sortedByDescending {it.age})//Сортировка по свойству age по убыванию.


                     //reverse и shuffle
    println(ss.reversed())//Функция reversed() изменяет порядок элементов на обратный.
    println(s.shuffled())//Функция shuffle() перемешивает элементы случайным образом.
}

//Ниже пример класса объекты которого мы намериваемся сортировать по именам.
class Runner(val age: Int, val name: String) : Comparable<Runner> {
    override fun compareTo(other: Runner): Int {
        return name.compareTo(other.name)
    }

    override fun toString(): String {
        return "$name($age) "
    }
}