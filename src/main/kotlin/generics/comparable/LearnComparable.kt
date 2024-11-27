package generics.comparable

fun main() {
    val e1 = Event(34)
    val e2 = Event(54)
    println(e1>e2)
}

class Event(val time: Int): Comparable<Event> {
    override fun compareTo(other: Event): Int = time.compareTo(other.time)
}