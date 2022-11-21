package util

class InputException {

    fun checkInputLength(input: String?) {
        when {

            checkTypeException(input!!) -> printException(TYPE_ERROR)
            checkRangeException(input.toInt()) -> printException(RANGE_ERROR)
        }
    }

    private fun checkRangeException(input: Int): Boolean = !(3..20).contains(input)

    private fun checkTypeException(input: String): Boolean {
        return try {
            input.toInt()
            false
        } catch (e: Exception) {
            true
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