package oop

//Ниже пример как мы можем из пакета functions импортировать функцию info, но изменив её название на infoNew.
import functions.info as infoNew

fun main() {
    infoNew("driver", "Tom", "Jim")
}