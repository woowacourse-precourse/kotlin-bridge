package bridge

class BridgeSizeException(inputData: String) {
    companion object {
        const val BRIDGE_SIZE_IS_NOT_INTEGER = "[ERROR] 입력한 다리 길이는 정수가 아닙니다."
        const val BRIDGE_SIZE_IS_NOT_AVAILABLE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."
    }

    init{
        isNotInteger(inputData)
        isNotBridgeNumber(inputData)
    }

    private fun isNotInteger(inputData: String) {
        if(!inputData.chars().allMatch { Character.isDigit(it) })
            throw IllegalArgumentException(BRIDGE_SIZE_IS_NOT_INTEGER)
    }

    private fun isNotBridgeNumber(inputData: String) {
        if(inputData.toInt() < 3 || inputData.toInt() > 20)
            throw IllegalArgumentException(BRIDGE_SIZE_IS_NOT_AVAILABLE)
    }
}