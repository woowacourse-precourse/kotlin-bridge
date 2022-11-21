package bridge

class BridgeSizeException(inputData: String) {
    init{
        isNotInteger(inputData)
        isNotBridgeNumber(inputData)
    }

    private fun isNotInteger(inputData: String) {
        TODO("기능구현")
    }

    private fun isNotBridgeNumber(inputData: String) {
        TODO("기능구현")
    }
}