package bridge

class InputErrorCheck {
    fun checkValidBridgeSize(userInput: String) {
        throwIsBridgeSizeNumberException(userInput)
        throwBridgeSizeRangeException(userInput)
    }

    private fun throwIsBridgeSizeNumberException(userInput: String) {
        val numbers = userInput.toCharArray().filter { number ->
            number in '0'..'9'
        }
        if (numbers.size != userInput.length)
            throw IllegalArgumentException("[ERROR] 다리 크기는 숫자여야 합니다.")
    }

    private fun throwBridgeSizeRangeException(userInput: String) {
        if (userInput.toInt() !in 3..20)
            throw IllegalArgumentException("[ERROR] 다리 크기는 3부터 20 사이의 숫자여야 합니다.")
    }

    fun throwMovingException(userInput: String) {
        if (userInput != "U" && userInput != "D")
            throw IllegalArgumentException("[ERROR] U 또는 D만 입력해야 합니다.")
    }

    fun throwGameCommandException(userInput: String) {
        if (userInput != "R" && userInput != "Q")
            throw IllegalArgumentException("[ERROR] R 또는 Q만 입력해야 합니다.")
    }
}
