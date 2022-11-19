package bridge

object BridgeException {

    private const val errorPrefix = "[ERROR] "
    private val bridgeSizeRegex = "\\d+".toRegex()

    fun isValidBridgeSize(input: String) {
        require(input.matches(bridgeSizeRegex) && input.toInt() in 3..20) {
            errorPrefix + "다리 길이는 3부터 20 사이의 숫자여야 한다."
        }
    }
}