package generics

fun main() {
                                    //Пример инвариантности.
    /**
     * Инвариантный тип означает, что тип должен точно соответствовать заданному — никакие подтипы
     * или супертипы не подойдут. В Kotlin, если ты не используешь in или out, тип является инвариантным.
     *
     * Например, вот так нельзя - val boxInvariance: BoxInvariant<Animal> = dogBox
     *
     * Вот так можно - val boxInvariance2: BoxInvariance<Dog> = dogBox
     *
     * Инвариантность: строгая работа с типом, без возможности подменять подтипы или суперклассы.
     */
    val animalBox: BoxInvariance<Animal> = BoxInvariance(Animal("Sharik"))
    val dogBox: BoxInvariance<Dog> = BoxInvariance(Dog("Tuzik"))
    val boxInvariance: BoxInvariance<Animal> = animalBox
    val boxInvariance2: BoxInvariance<Dog> = dogBox
    println(boxInvariance.get().name)
    println(boxInvariance2.get().name)

                                   //Пример ковариантности.
    /**
     * Ковариантный тип позволяет использовать подтипы (наследников) вместо суперклассов.
     * В Kotlin ковариантность обозначается ключевым словом out, что означает "используй
     * только для возвращаемого значения" (выходные данные).
     *
     * Вот так, нельзя - val boxCovariance2: BoxCovariance<Dog> = animalBox2
     */
    val dogBox2: BoxCovariance<Dog> = BoxCovariance(Dog("Sam"))
    val animalBox2: BoxCovariance<Animal> = BoxCovariance(Dog("Tuzik"))
    val boxCovariance: BoxCovariance<Animal> = dogBox2
    val boxCovariance2: BoxCovariance<Animal> = animalBox2//Вот так можно.
    println(boxCovariance.get().name)
    println(boxCovariance2.get().name)

                                  //Пример контравариантности.
    /**
     * Контравариантный тип работает в обратную сторону: ты можешь класть объекты более конкретных
     * типов (подтипов), но не можешь быть уверен, какого именно типа объект ты достанешь. В Kotlin
     * это обозначается словом in.
     *
     * Контравариантность (in T): можно только добавлять объекты в контейнер, но нельзя извлекать их
     * в определённом виде. Позволяет использовать суперклассы.
     */
    val dogBox3: BoxContravariance<Dog> = BoxContravariance()
    dogBox3.put(Dog("Tom"))
    dogBox3.put(Dog("Tom2"))
    dogBox3.put(Dog("Tom3"))
    val listDogs = dogBox3.get()
    for (i in listDogs) {
        print(i.name + " ")
    }
    println()
}

open class Animal(val name: String)

class Dog(nameDog: String) : Animal(nameDog)

class BoxInvariance<T>(private val obj: T) {
    fun get(): T {
        return obj
    }
}

class BoxCovariance<out T>(private val obj: T) {
    fun get(): T = obj
}

class BoxContravariance<in T> {
    private val items: MutableList<@UnsafeVariance T> = mutableListOf()
    fun put(p: T){
        items.add(p)
    }
    fun get(): List<@UnsafeVariance T> {
        return items
    }
}