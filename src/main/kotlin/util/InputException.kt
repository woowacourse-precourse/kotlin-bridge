package util

class InputException {

    fun checkBridgeLength(input: String?) {
        when {
            checkNullException(input) -> printException(NULL_ERROR)
            checkTypeException(input!!) -> printException(TYPE_ERROR)
            checkRangeException(input.toInt()) -> printException(RANGE_ERROR)
        }
    }

    fun checkMoveCommand(input: String?) {
        when {
            checkNullException(input) -> printException(NULL_ERROR)
            checkCommandException(input!!) -> printException(COMMAND_ERROR)
        }
    }

    fun checkRetryCommand(input: String?) {
        when {
            checkNullException(input) -> printException(NULL_ERROR)
            checkRetryException(input!!) -> printException(COMMAND_ERROR)
        }
    }

    private fun checkRetryException(input: String): Boolean = !listOf("R", "Q").contains(input)

    private fun checkCommandException(input: String): Boolean = !listOf("U", "D").contains(input)

    private fun checkNullException(input: String?): Boolean = input.isNullOrEmpty()

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
        const val NULL_ERROR = "입력 값이 없습니다."
        const val RANGE_ERROR = "3~20의 범위가 아닙니다."
        const val TYPE_ERROR = "올바른 형식이 아닙니다."
        const val COMMAND_ERROR = "U, D 만 입력 가능합니다."
        const val REQ_ERROR = "R, Q 만 입력 가능합니다."
    }
}