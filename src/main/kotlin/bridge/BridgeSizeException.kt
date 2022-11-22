package bridge

class BridgeSizeException(inputData: String) {
    init{
        isNotInteger(inputData)
        isNotBridgeNumber(inputData)
    }

    private fun isNotInteger(inputData: String) {
        if(!inputData.chars().allMatch { Character.isDigit(it) })
            throw IllegalArgumentException(Message.BRIDGE_SIZE_IS_NOT_INTEGER)
    }

    private fun isNotBridgeNumber(inputData: String) {
        if(inputData.toInt() < 3 || inputData.toInt() > 20)
            throw IllegalArgumentException(Message.BRIDGE_SIZE_IS_NOT_AVAILABLE)
    }
}