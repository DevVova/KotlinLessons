package oop.l33

fun main() {
    val cl1 = Outer(22)
    cl1.printOuter()
    cl1.printNestedPrivate()
    val cl2 = Outer.Nested(33)
    cl2.bb = 88
    cl2.printNested()
    val cl3 = Outer(11)
    cl3.Inner(66, 44).printInner()
}

class Outer(val a: Int) {
    var b: Int = 3
    private val n: NestedPrivate = NestedPrivate(a)

    fun printOuter() {
        println("a = $a, b = $b.")
    }

    fun printNestedPrivate() {
        println(n.aaa)
    }

    class Nested(private val aa: Int) {
        var bb: Int = 7

        fun printNested() {
            println("a = $aa, b = $bb.")
        }
    }

    private class NestedPrivate(val aaa: Int)

    inner class Inner(val a: Int, val b: Int) {
        fun printInner() {
            println("a outer = ${this@Outer.a}, b inner = $b.")
            this@Outer.printOuter()
        }
    }
}