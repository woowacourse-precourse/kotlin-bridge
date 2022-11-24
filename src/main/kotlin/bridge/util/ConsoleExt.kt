package bridge.util

fun println(format: String, vararg args: Any?) {
    kotlin.io.println(String.format(format, *args))
}

fun println(format: Any, vararg args: Any?) {
    kotlin.io.println(String.format(format.toString(), *args))
}