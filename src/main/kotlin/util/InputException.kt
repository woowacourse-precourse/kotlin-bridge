package util

class InputException {
    private fun printException(message : String) {
        throw IllegalArgumentException("[ERROR] $message")
    }
}