package language.enums

fun main() {
    val dayOfWeek = DaysOfWeek.Tuesday
    println(dayOfWeek)
    val dayArray = DaysOfWeek.entries.toTypedArray()//Взяли enum и преобразовали в массив.
    for (i in dayArray) {
        print("$i   ")
    }
    println()

    //Ниже показан пример как можно создать массив из сокращённых названий дней недели.
    val daysShortNameArray = dayArray.map { it.shortName }.toTypedArray()
    for (i in daysShortNameArray) {
        print("$i   ")
    }
    println()
}


//Вот так я думаю нужно создавать дни недели в приложениях.
enum class DaysOfWeek(val shortName: String) {
    Monday("Mo"),
    Tuesday("Tu"),
    Wednesday("We"),
    Thursday("Th"),
    Friday("Fr"),
    Saturday("Sa"),
    Sunday("Su")
}