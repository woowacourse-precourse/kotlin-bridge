package bridge

fun main() {
    val inputView = InputView()
    val outputView = OutputView()

    outputView.printGameStart()
    outputView.printInputBridgeSize()
    val bridgeSize = inputView.readBridgeSize()

}