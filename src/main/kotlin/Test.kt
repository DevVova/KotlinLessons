fun main() {
    val result = function1 { num1 ->
        num1 * 3
    }
    println(result)
}

fun function1(function2: (Int) -> Int): Int {
    val number = 7
    val res = function2(number)
    return res
}