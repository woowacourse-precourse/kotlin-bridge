package bridge.util

object Validator {
    private val BRIDGE_MIN_SIZE = 3
    private val BRIDGE_MAX_SIZE = 20

    fun checkBridgeSize(size: String) {
        if (size.toIntOrNull() == null){
            throw IllegalArgumentException("[ERROR] 숫자 형태로 입력해주세요.")
        }

        var bridgeSize = size.toInt()

        if (bridgeSize !in BRIDGE_MIN_SIZE..BRIDGE_MAX_SIZE){
            throw IllegalArgumentException("[ERROR] 3이상 20이하의 숫자를 입력해주세요.")
        }
    }
}