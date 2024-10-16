package javadoc

/**
 * Это документация к классу под названием SomeClass.
 */
class SomeClass {
    /**
     * А это собственно свойство класса.
     */
    private val someValue: Int = 9

    /**
     * Это описание метода класса [SomeClass]
     * @property someValue - это свойство класса. property используется для свойств класса.
     * @param toDo - а это входной параметр метода. param используется для параметров метода.
     * @return - это возвращаемое значение в виде строки.
     */
    fun someFunction(toDo: String): String {
        println("Что то делает этот класс - $toDo. А значение равно $someValue. New value equals $NEWVALUE")
        val str = "Возвращаемое значение"
        return str
    }
}

const val NEWVALUE = 3