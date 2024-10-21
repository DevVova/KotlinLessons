package oopplus

import kotlin.reflect.KProperty

/**
 * Делегированные свойства позволяют делегировать получение или присвоение их значения
 * во вне - другому классу. Это позволяет нам добавить некоторую дополнительную логику
 * при операции со свойствами, например, логирование, какую-то предобработку и т.д.
 *
 * После типа данных свойства идет ключевое слово by, после которого указывается
 * выражение. Выражение представляет класс, который условно называется делегатом.
 * Делегаты свойств могут не применять никаких интерфейсов, однако они должны
 * предоставлять функции getValue() и setValue(). А выполнение методов доступа get()
 * и set(), которые есть у свойства, делегируется функциям getValue() и setValue()
 * класса делегата.
 */
fun main() {
    val vova = User("Vova")
    println(vova.name)
    vova.name = "Vladimir"
    println(vova.name)

    val tom = User2()
    println(tom.name)
}

class Delegate(val name: String) {
    operator fun getValue(thisRef: User, property: KProperty<*>): String {
        println("Вот имя пользователя.")
        return name
    }
    operator fun setValue(thisRef: User, property: KProperty<*>, value: String) {
        println("Имя изменено.")
    }
}

class User(nameIn: String) {
    var name by Delegate(nameIn)
}

class Delegate2 {
    private var nameDelegate = "Tom"
    operator fun getValue(thisRef: User2, property: KProperty<*>): String {
        return nameDelegate
    }
    operator fun setValue(thisRef: User2, property: KProperty<*>, value: String) {
        nameDelegate = value
    }
}

class User2 {
    var name: String by Delegate2()
}