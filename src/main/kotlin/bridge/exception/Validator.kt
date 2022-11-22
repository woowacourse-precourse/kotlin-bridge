package bridge.exception

private enum class ErrorMessage(val message: String) {
    NOT_IN_RANGE("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    NOT_U_OR_D("[ERROR] U 또는 D 만 입력해주세요."),
    NOT_R_OR_Q("[ERROR] R 또는 Q 만 입력해주세요.")
}

class Validator {

    fun checkBridgeSize(input: String): Int {
        val size = input.toIntOrNull() ?: throw IllegalArgumentException(ErrorMessage.NOT_IN_RANGE.message)
        if ((size < 3) or (size > 20)) throw IllegalArgumentException(ErrorMessage.NOT_IN_RANGE.message)
        return size
    }

    fun checkMoving(input: String): String {
        if ((input != "U") and (input != "D")) {
            throw IllegalArgumentException(ErrorMessage.NOT_U_OR_D.message)
        }
        return input
    }

    fun checkGameCommand(input: String): String {
        if ((input != "R") and (input != "Q")) {
            throw IllegalArgumentException(ErrorMessage.NOT_R_OR_Q.message)
        }
        return input
    }
}
