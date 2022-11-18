package bridge.utils

class UserInputValidate {
    fun validateBridgeSize(inputBridgeSize: String): Int {
        isValidType(inputBridgeSize)
        isValidInputRange(inputBridgeSize.toInt())
        return inputBridgeSize.toInt()
    }

    private fun isNumber(s: String?): Boolean {
        return if (s.isNullOrEmpty()) false else s.all { Character.isDigit(it) }
    }

    private fun isValidType(bridgeSize: String) {
        if (!isNumber(bridgeSize)) {
            throw IllegalArgumentException("[ERROR]: 다리의 길이는 숫자로만 입력되어야 합니다.")
        }
    }

    private fun isValidInputRange(bridgeSize: Int) {
        if (bridgeSize < MIN_BRIDGE_SIZE || MAX_BRIDGE_SIZE < bridgeSize) {
            throw IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.")
        }
    }

    companion object {
        const val MIN_BRIDGE_SIZE = 3
        const val MAX_BRIDGE_SIZE = 20
    }
}