package bridge

object BridgeException {

    private val bridgeSizeRegex = "\\d+".toRegex()
    private val movingRegex = "[UD]".toRegex()
    private val gameCommandRegex = "[RQ]".toRegex()

    private const val ERROR_PREFIX = "[ERROR] "
    private const val BRIDGE_SIZE_INTEGER_EXCEPTION = ERROR_PREFIX + "다리 길이는 숫자여야 한다."
    private const val BRIDGE_SIZE_RANGE_EXCEPTION = ERROR_PREFIX + "다리 길이는 3부터 20 사이의 숫자여야 한다."
    private const val MOVING_EXCEPTION = ERROR_PREFIX + "U 또는 D만 입력할 수 있다."
    private const val GAME_COMMAND_EXCEPTION = ERROR_PREFIX + "R 또는 Q만 입력할 수 있다."

    fun isValidBridgeSize(input: String) {
        if (input.matches(bridgeSizeRegex).not()) {
            println(BRIDGE_SIZE_INTEGER_EXCEPTION)
            throw NoSuchElementException(BRIDGE_SIZE_INTEGER_EXCEPTION)
        }

        require(input.toInt() in 3..20) {
            BRIDGE_SIZE_RANGE_EXCEPTION
        }
    }

    fun isValidMoving(input: String) {
        require(input.matches(movingRegex)) {
            MOVING_EXCEPTION
        }
    }

    fun isValidGameCommand(input: String) {
        require(input.matches(gameCommandRegex)) {
            GAME_COMMAND_EXCEPTION
        }
    }
}