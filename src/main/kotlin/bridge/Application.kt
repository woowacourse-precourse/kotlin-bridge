package bridge

fun main() {
    // TODO: 프로그램 구현
}


fun inputBridgeSize() : Int {
    OutputView().printInputBridgeSizeMessage()
    return getBridgeSize(InputView().readBridgeSize())
}

fun getBridgeSize(input : String?) : Int {
    try {
        Validator().checkBridgeLength(input)
        return input!!.toInt()
    } catch(e : IllegalArgumentException) {
        OutputView().printError(e)
        return inputBridgeSize()
    }
}
