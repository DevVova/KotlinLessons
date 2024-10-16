package oopplus

/**
 * Ключевое слово null представляет специальный литерал, который указывает, что переменная
 * не имеет как такового значения. Мы можем присвоить значение null только переменной, которая
 * представляет тип Nullable. Чтобы превратить обычный тип в тип nullable, достаточно поставить
 * после названия типа вопросительный знак.
 */
fun main() {
    val a: Int? = null
    println(a)

    val myBook: Book? = null//Можно так создавать на базе класса объекты другого нулебл класса.
    val myBook2 = Book()

    /*
    Нельзя передавать значения nullable-типов в качестве аргумента в функцию, где требуется
     конкретное значение, которое не может представлять null.
     */
    println(sum(23, 2))//А вот так нельзя - println(sum(23, a))

    //Ниже пример как мы можем принимать в качестве значения нулебл тип.
    var currency: Int? = null
    currency = 34
    val myValue: Int = currency ?: 0//Если бы currency был null, то myValue было бы равно 0.
    println(myValue)

    //Оператор ?. позволяет объединить проверку значения объекта на null и обратиться к функциям или свойствам этого объекта.
    var message: String? = "Hello"
    val length: Int? = message?.length
    println(length)
    message = null
    val length2 = message?.length ?: 0
    println(length2)

    //Короче если тип нулебл, то нужно к его свойствам и методам обращаться через ?
    val book: Book2? = Book2(null)
    val p: Int = book?.price ?: 0
    println(p)
    book?.info()

    val book3: Book3? = Book3("My Book")
    val n: String? = book3?.name?.uppercase()
    val book4: Book3? = Book3(null)
    val n2: String = book4?.name?.uppercase() ?: "don't name"
    println(n)
    println(n2)
    book3?.info()

    /**
     * Оператор !! (not-null assertion operator) принимает один операнд. Если операнд равен null,
     * то генерируется исключение. Если операнд не равен null, то возвращается его значение.
     * То есть данный оператор применяется, когда мы уверены, что значение НЕ равно null.
     */
    var str: String? = "Tom"
    val anyName = str!!
    println(anyName)
    var lengthName = str!!.length
    println(lengthName)

    //Если вдруг сомневаемся.
    try {
        str = null
        val n3 = str!!
    } catch (e: Exception) {
        e.message
    }
}

class Book

fun sum(a: Int, b: Int): Int {
    return a + b
}

class Book2(val price: Int?) {
    fun info() {
        println("The price of this book is $price.")
    }
}

class Book3(val name: String?) {
    fun info() {
        println("This book is $name.")
    }
}