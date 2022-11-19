package bridge

object BridgeException {

    private const val ERROR_PREFIX = "[ERROR] "
    private val bridgeSizeRegex = "\\d+".toRegex()
    private val movingRegex = "[UD]".toRegex()

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
}