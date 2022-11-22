package bridge

class InputValidator(private val inputNumber: String) {
    enum class ErrorMessage(val sentence: String) {
        BRIDGE_LENGTH_ERROR("[ERROR] 다리 길이는 3 이상 20 이하의 숫자여야 합니다."),
        DIRECTION_ERROR("[ERROR] U(위 칸)와 D(아래 칸) 중 하나의 문자만 입력할 수 있습니다."),
        RESTART_OR_QUIT_ERROR("[ERROR] R(재시작)과 Q(종료) 중 하나의 문자만 입력할 수 있습니다.")
    }

    fun checkBridgeLengthException(): Boolean {
        checkLetter()
        if (inputNumber.toInt() !in 3..20) {
            throw IllegalArgumentException(ErrorMessage.BRIDGE_LENGTH_ERROR.sentence)
        }
        return true
    }

    private fun checkLetter() {
        val regexOnlyNumber = Regex("-?\\d+(\\.\\d+)?")
        if (!inputNumber.matches(regexOnlyNumber)) {
            throw IllegalArgumentException(ErrorMessage.BRIDGE_LENGTH_ERROR.sentence)
        }
    }

    fun checkDirectionException(): Boolean {
        if (!(inputNumber == BridgeGame.CommendKey.UP.letter || inputNumber == BridgeGame.CommendKey.DOWN.letter)) {
            throw IllegalArgumentException(ErrorMessage.DIRECTION_ERROR.sentence)
        }
        return true
    }

    fun checkRestartOrQuitException(): Boolean {
        if (!(inputNumber == BridgeGame.CommendKey.RESTART.letter || inputNumber == BridgeGame.CommendKey.Quit.letter)) {
            throw IllegalArgumentException(ErrorMessage.RESTART_OR_QUIT_ERROR.sentence)
        }
        return true
    }
}