package base

const val PI = 3.14//Константы объявляются на самом верхнем уровне, вне классов и функций. Тип данных должен быть базовым.

fun main() {
    //Ниже пример объявления переменной определённого типа, а после присвоение ему значения
    val numberOne: Int
    numberOne = 9//Обычно так не пишут, а сразу инициализируют после объявления, также, как здесь, можно опустить тип переменной.
    println(numberOne)
    val variable1 = 2//С помощью ключевого слова val определяется неизменяемая переменная (immutable variable) или переменная только для чтения (read-only).
    var variable2 = 5//А у переменной, которая определена с помощью ключевого слова var мы можем многократно менять значения (mutable variable).
    println("Variable number one equals $variable1, another variable equals $variable2.")
    variable2 = 9
    println("New value for variable number two equals $variable2.")
    println("Pi = $PI")
}