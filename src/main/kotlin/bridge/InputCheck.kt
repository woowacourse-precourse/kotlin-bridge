package bridge

enum class Error(val message: String) {
    NOT_NUMBER("[ERROR] 숫자를 입력해야 합니다."),
    NOT_RANGE("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
}

class InputCheck {
    fun checkBridgeLength(input: String) {
        require(inputIsNumber(input)) { Error.NOT_NUMBER.message }
        require(checkRange(input)) { Error.NOT_RANGE.message }
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