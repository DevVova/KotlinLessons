package practice.time

import java.time.LocalDate
import java.time.YearMonth

fun main() {
    val previousWeek = Array(7) { 1 }
    val currentWeek = Array(7) { 1 }
    val nextWeek = Array(7) { 1 }

    val localDate = LocalDate.now()
    val currentYear = localDate.year
    val currentMonth = localDate.monthValue
    val currentDay = localDate.dayOfMonth
    val currentDayOfWeekNumber = localDate.dayOfWeek.value//Номер текущего дня недели.

    val lengthPreMonth = YearMonth.of(currentYear, currentMonth - 1)
        .lengthOfMonth()//Так можно узнать длину предыдущего месяца определённого года.

    //Ниже узнаем какое число будет в понедельник текущей недели.
    val firstDayOfWeekNumber = if (currentDay < currentDayOfWeekNumber) {
        lengthPreMonth - currentDayOfWeekNumber + currentDay + 1
    } else currentDay - currentDayOfWeekNumber + 1

    //Ниже изменяем элементы массива currentWeek, то есть задаём им корректные значения.
    var dayNumber = firstDayOfWeekNumber - 1//Инициализируем переменную используемую для изменения значения элементов массива currentWeek.
    var i = 0
    while (i <= 6) {
        currentWeek[i] = ++dayNumber
        i++
        if (dayNumber == lengthPreMonth) dayNumber = 0
    }

    //А это ниже просто для того, чтобы посмотреть всё ли верно записалось в массив currentWeek.
    for (ii in currentWeek) {
        print("$ii  ")
    }
    println()
}