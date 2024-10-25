package collections

fun main() {
    //Для группировки элементов коллекции/последовательности применяется функция groupBy():
    /**
     * Обе версии в качестве параметра принимают функцию, которая определяет критерий группировки.
     * Вторая версия в дополнение принимает функцию преобразования. Результатом функции
     * является объект Map, который хранит набор групп. Ключами являются критерии
     * группировки - ключи групп, а значениями - списки List, которые соответствуют этим
     * критериям группировки и представляют группы.
     */
    val listOfEmployee = listOf(
        Employee("BMV", "Mark"),
        Employee("Audi", "Ted"),
        Employee("Boss", "Vova"),
        Employee("BMV", "Sam"),
        Employee("Audi", "Coin"),
        Employee("BMV", "Fill"),
    )
    val companies = listOfEmployee.groupBy { it.company }
    println(companies)

    for (c in companies) {
        println("${c.key}  ")
        for (d in c.value) {
            println(d)
        }
        println()
    }

    val companies2 = listOfEmployee.groupBy({ it.company }) { it.name }
    println(companies2)
}

class Employee(val company: String, val name: String) {
    override fun toString(): String {
        return this.name
    }
}