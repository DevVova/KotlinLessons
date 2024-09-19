package apps

fun main() {
    print("Введите преодолённое расстояние в метрах: ")
    val distance = readln().toInt()
    print("Введите время в часах за которое вы пробежали это расстояние, если меньше часа то пишите 0: ")
    val hour = readln().toInt()
    print("Введите время в минутах за которое вы пробежали это расстояние, если меньше минуты то пишите 0: ")
    val minutes = readln().toInt()
    print("Введите время в секундах за которое вы пробежали это расстояние: ")
    val seconds = readln().toInt()

    calculateOfPace(distance, hour, minutes, seconds)
}

fun calculateOfPace(distance: Int, hour: Int, minutes: Int, seconds: Int) {
    val totalTimeInSeconds = (hour * 3600) + (minutes * 60) + seconds
    val paceInSecondsPerKm = totalTimeInSeconds / (distance / 1000) // Время на километр в секундах

    val minutesOfPace = paceInSecondsPerKm / 60 // Минуты на километр
    val secondsOfPace = paceInSecondsPerKm % 60 // Оставшиеся секунды
    println("Вы пробежали с темпом $minutesOfPace минут и $secondsOfPace секунд на километр.")
}