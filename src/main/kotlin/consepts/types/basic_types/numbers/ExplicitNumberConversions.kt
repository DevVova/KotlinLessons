package consepts.types.basic_types.numbers

/**
 * Нужно внимательно следить чтобы переменным одного типа соответствовали переменные
 * другого типа и их значения.
 */

fun main() {
    val t = 1
    val tt: Long = t.toLong()//tt = t не может быть, хотя Int как бы входит в множество Long.
    println(tt)

    val ttt = 22L + 6//Так можно, 6 будет неявно приведена к Long.
    println(ttt)

    val x: Float = t.toFloat() + 2F//Для явного приведения одного типа к другому существует встроенная функция to...().
    println(x)
}