package generics.p41

fun main() {
                                     //Инвариантность.
    //Мы можем присвоить переменным по умолчанию только объекты их типов:
    val box: Box<Int> = Box(7)
    val box2: Box<Number> = Box(3.3)
    val box3: Box<Number> = box2//А вот box присвоить нельзя так как будет ошибка компиляции: Box<Int> не является подтипом Box<Number>
    val box4: Box<Int> = box//Хоть Int и наследуется от Number, но нельзя присвоить box3 или box2.
    println("box3 = ${box3.value}, box4 = ${box4.value}")

                                     //Ковариантность.
    val b: Box1<Int> = Box1(34)
    val b1: Box1<Number> = Box1(4.4)
    val b2: Box1<Number> = b//Однако мы можем только читать данные, но не записывать их.
    val b4: Box1<Int> = b//А вот b1 и b2 нельзя, так как Int это подкласс Number.
                                     //Контравариантность.
    val bb: Box2<Int> = Box2()
    val bb1: Box2<Number> = Box2()
    val bb2: Box2<Number> = bb1//А вот bb нельзя, так как Number это супер класс Int.
    val bb3: Box2<Int> = bb1
}

class Box<T>(val value: T)//Класс является инвариантным.

class Box1<out T>(val value: T)//Класс является ковариантным.

class Box2<in T>() {
    fun set(value: T) {
        println(value)
    }
}