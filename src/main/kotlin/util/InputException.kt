package util

class InputException {

    fun checkInputLength(input: String) {
        try {
            val length = input.toInt()
        } catch (e: Exception) {
            printException(TYPE_ERROR)
        }
    }

    private fun printException(message: String) {
        throw IllegalArgumentException("[ERROR] $message")
    }

    companion object {
        const val RANGE_ERROR = "3~20의 범위가 아닙니다."
        const val TYPE_ERROR = "올바른 형식이 아닙니다."
    }
}