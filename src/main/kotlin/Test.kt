fun main() {
    val result = "Wow"
    f {
        println(result)
    }
    println("Good job!")
}

fun f(ff: (String) -> Unit) {
    val str = "Hello"
    ff(str)
}