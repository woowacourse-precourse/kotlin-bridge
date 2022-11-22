package util

class InputException {

    fun checkMoveCommand(input: String?) {
        val range = listOf("U", "D")
        require(range.contains(input))
    }

    fun checkRetryCommand(input: String?) {
        val range = listOf("R", "Q")
        require(range.contains(input))
    }

    fun checkRangeException(input: String?) {
        val range = (3..20)
        require(range.contains(input?.toInt()))
    }

    fun printException(message: String) {
        println("[ERROR] : $message")
    }

    companion object {
        const val RANGE_ERROR = "3~20의 범위가 아닙니다."
        const val COMMAND_ERROR = "U, D 만 입력 가능합니다."
        const val RETRY_ERROR = "R, Q 만 입력 가능합니다."
    }
}