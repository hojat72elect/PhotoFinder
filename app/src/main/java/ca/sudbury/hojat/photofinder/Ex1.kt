package ca.sudbury.hojat.core

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

fun main() {
    println("Hello, world!")

    print("this is executed immediately!")
}

suspend fun stallForTime() {
    withContext(Dispatchers.Default) {
        delay(2000L)
    }
}
