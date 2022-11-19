package bridge

object BridgeException {

    private const val ERROR_PREFIX = "[ERROR] "
    private val bridgeSizeRegex = "\\d+".toRegex()
    private val movingRegex = "[UD]".toRegex()
    private val gameCommandRegex = "[RQ]".toRegex()

    fun isValidBridgeSize(input: String) {
        require(input.matches(bridgeSizeRegex) && input.toInt() in 3..20) {
            ERROR_PREFIX + "다리 길이는 3부터 20 사이의 숫자여야 한다."
        }
    }

    fun isValidMoving(input: String) {
        require(input.matches(movingRegex)) {
            ERROR_PREFIX + "U 또는 D만 입력할 수 있다."
        }
    }

    fun isValidGameCommand(input: String) {
        require(input.matches(gameCommandRegex)) {
            ERROR_PREFIX + "R 또는 Q만 입력할 수 있다."
        }
    }
}