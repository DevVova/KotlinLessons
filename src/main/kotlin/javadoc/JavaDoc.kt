package javadoc

/**
 * Данный файл описывает как создавать документацию javadoc.
 *
 * Вот пример как можно читать документацию к классу из другого файла, не
 * переходя на файл сам, а только читая к нему документацию [SomeClass].
 * @author Zabotin Vladimir "ZabotinV78@gmail.com"
 * @version 1.0
 * @since 4.4
 * @see SomeClass
 */
fun main() {
    /** А это документация к переменной. */
    val value = 9
    println(value)

    val someC = SomeClass()
    someC.someFunction("Hello")
}