package oopplus

/**
 * Исключение представляет событие, которое возникает при выполнении программы и нарушает
 * ее нормальный ход. Например, при передаче файла по сети может оборваться сетевое
 * подключение, и в результате чего может быть сгенерировано исключение. Если исключение
 * не обработано, то программа падает и прекращает свою работу. Поэтому при возникновении
 * исключений их следует обрабатывать.
 */
fun main() {
    try {
        val a = 8
        val b = 0
        val c = a / b
        println(c)
    } catch (ex: ArrayIndexOutOfBoundsException) {
        println(ex.message)//Можно сразу несколько исключений, только нужно учитывать что после срабатывания первого, второе уже не сработает.
    } catch (e: Exception) {
        println(e.message)//Так можно получить сообщение об исключении.
    } finally {
        println("Error.")
    }

    println()

    try {
        checkAge(1225)
    } catch (e: Exception) {
        println(e.message)
    } finally {
        println("Проверка возраста выполнена.")
    }
    println()

    //Конструкция try может возвращать значение.
    val r = try {checkAge2(12)} catch (e: Exception) {null} finally { println("Ok") }
    println(r)
    println()
    var res = try {checkAge(132)} catch (e: Exception) {null}
    println(res)
    println()
    res = try { checkAge(45) } catch (e: Exception) { println("Age is valid. It is good!")}
    println(res)
    println()

    val res2 = try { checkAge2(-77) } catch (e: Exception) {println(e.message); 18}
    println(res2)
}

fun checkAge(age: Int) {
    if (age !in 1..130) throw Exception("Неверный возраст")
    println("Age $age is valid.")
}

fun checkAge2(age: Int): Int {
    if (age !in 1..130) throw Exception("Неверный возраст")
    println("Age $age is valid.")
    return age
}