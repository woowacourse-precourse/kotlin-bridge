package bridge

fun main() {
    OutputView().printStartMessage()
    OutputView().printAskBridgeSize()
    val size = InputView().readBridgeSize()
}
