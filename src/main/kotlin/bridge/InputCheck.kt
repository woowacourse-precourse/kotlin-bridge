package bridge

enum class Error(val message: String) {
    NOT_NUMBER("[ERROR] 숫자를 입력해야 합니다."),
    NOT_RANGE("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    NOT_U_OR_D("[ERROR] U(위 칸)와 D(아래 칸) 중 하나의 문자만 입력할 수 있습니다."),
    NOT_R_OR_Q("[ERROR] R(재시작)와 Q(종료) 중 하나의 문자만 입력할 수 있습니다."),
}

class InputCheck {
    fun checkBridgeLength(input: String) {
        require(inputIsNumber(input)) { Error.NOT_NUMBER.message }
        require(checkRange(input)) { Error.NOT_RANGE.message }
    }

    fun checkChooseSpace(input: String) {
        require(isUOrD(input)) { Error.NOT_U_OR_D.message }
    }

    fun checkReGameCommand(input: String) {
        require(isROrQ(input)) { Error.NOT_R_OR_Q.message }
    }

    private fun isROrQ(input: String): Boolean {
        if (input != "R" && input != "Q") return false
        return true
    }

    private fun isUOrD(input: String): Boolean {
        if (input != "U" && input != "D") return false
        return true
    }

    private fun inputIsNumber(input: String): Boolean {
        input.forEach {
            if (it.code !in 48..57) return false
        }
        return true
    }

    private fun checkRange(input: String): Boolean {
        if (input.toInt() !in 3..20) return false
        return true
    }
}