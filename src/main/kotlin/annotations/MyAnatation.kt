package annotations

/**
 * В Kotlin аннотации (annotations) используются для добавления метаданных к коду.
 * Эти метаданные могут быть использованы компилятором или в рантайме для различных
 * целей, таких как управление сериализацией, валидацией, логированием, или
 * взаимодействием с фреймворками.
 */
fun main() {
    trade(3, "USD") { lot, ticker ->
        buy(lot, ticker)
    }

    // Пример использования рефлексии для получения аннотации
    val method = ::buy
    val annotation = method.annotations.filterIsInstance<Trading>().firstOrNull()
    annotation?.let {
        println("Trading annotation description: ${it.description}")
    }
}

//@Target — указывает, к каким элементам можно применять аннотацию.
@Target(
    AnnotationTarget.CLASS,
    AnnotationTarget.FUNCTION,
    AnnotationTarget.VALUE_PARAMETER // Указываем возможность применения к параметрам функции
)
//@Retention — указывает, где аннотация сохраняется: в байт-коде или только на уровне исходного кода.
/*
  В Kotlin есть три уровня удержания (retention):

  SOURCE: аннотация присутствует только в исходном коде и не сохраняется в скомпилированном байт-коде.
  Это означает, что аннотация используется только на этапе компиляции и недоступна в рантайме.

  BINARY: аннотация сохраняется в байт-коде, но недоступна в рантайме.

  RUNTIME: аннотация сохраняется в байт-коде и доступна через рефлексию во время выполнения программы.
 */
@Retention(
    AnnotationRetention.RUNTIME
)
annotation class Trading(val description: String)//Эта аннотация принимает один параметр.

@Trading("Это аннотация для торговли.")
fun buy(lot: Int, ticker: String) {
    println("Robot buy $ticker. Lot is $lot.")
}

fun trade(lot: Int, ticker: String, @Trading("trading now") op: (Int, String) -> Unit) {
    op(lot, ticker)
}