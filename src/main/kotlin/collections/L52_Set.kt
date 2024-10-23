package collections

/**
 * Интерфейс Set представляет неупорядоченный набор объектов, который хранит только
 * уникальные объекты. Интерфейс Set представляет неизменяемый (immutable) набор.
 * Set расширяет интерфейс Collection и соответственно все его методы.
 *
 * Для создания неизменяемого (immutable) набора используется функция setOf().
 *
 * Изменяемые (mutable) наборы представлены интерфейсом MutableSet, который расширяет
 * интерфейсы Set и MutableCollection, соответственно поддерживает методы по изменению коллекции.
 *
 * Для создания изменяемых (mutable) наборов применяется функция mutableSetOf().
 */
fun main() {
    val s = setOf(2, 45, 6, 2, 24)
    println(s)
    println(s.size)
    println(s.toList()[2])//Так как set это неупорядоченный набор элементов, то вот так можно получить значение элемента третьего.
    val l = listOf(2, 44, 5, 66)
    val sl = l.toSet()//Вот так можно преобразовать список в набор.
    println(sl)
    //  объединение множеств
    val all = s union sl//Но можно было и так как в примере ниже.
    println(all)
    // пересечение множеств(возвращает элементы, которые есть в обоих множествах)
    val common = s.intersect(sl)
    println(common)
    // вычитание множеств(возвращает элементы, которые есть в первом множестве, но отсутствуют во втором)
    val different = s subtract sl
    println(different)

    //LinkedHashSet: объединяет возможности хеш-таблицы и связанного списка. Создается с помощью функции linkedSetOf().
    //LinkedHashSet гарантирует, что элементы будут храниться в порядке их добавления.
    /**
     * Особенности LinkedHashSet:
     *
     * Обеспечивает уникальность элементов, как и любой другой Set.
     *
     * Сохраняет порядок вставки элементов.
     *
     * Эффективность операций такая же, как у HashSet (O(1) для добавления, удаления, проверки наличия элемента).
     */
    val linkedHashSet = linkedSetOf(49, 4, 99)
    linkedHashSet.add(57)
    println(linkedHashSet)
    linkedHashSet.removeIf { it % 2 == 0 }//Удаление элементов по условию.
    println(linkedHashSet)

    //HashSet: представляет хеш-таблицу. Создается с помощью функции hashSetOf().
    /**
     * Хеш-таблица — это структура данных, которая обеспечивает быструю вставку, удаление
     * и поиск элементов за амортизированное время O(1). Она использует специальную
     * технику хеширования, чтобы преобразовать ключи в индексы массива, что позволяет
     * эффективно хранить и находить данные.
     *
     * Как работает хеш-таблица:
     * Хеш-функция: Каждый элемент, который нужно сохранить, проходит через хеш-функцию,
     * которая преобразует ключ элемента (например, число, строку или объект) в индекс
     * массива. Этот индекс указывает место, где элемент будет храниться.
     *
     * Хеш-значение: Результат хеш-функции — это числовое значение, называемое хеш-значением.
     * Оно указывает, в какой ячейке массива должен храниться элемент.
     *
     * Коллизии: Иногда два разных элемента могут получить одно и то же хеш-значение — это
     * называется коллизией. Хеш-таблицы используют различные стратегии для разрешения
     * коллизий (например, цепочки или метод открытой адресации).
     *
     * Преимущества: Основное преимущество хеш-таблицы заключается в том, что операции вставки,
     * поиска и удаления могут быть выполнены за постоянное время (O(1)), что делает её очень
     * эффективной для больших объемов данных.
     */
    //HashSet не гарантирует порядок элементов.
    val hashSet = hashSetOf(48, 33, 2, 12, 9, 36, 6)
    println(hashSet)
    hashSet.removeIf {it > 40}
    println(hashSet)
    val h = hashSet.sortedDescending()//Отсортируем по убыванию.
    println(h)
}