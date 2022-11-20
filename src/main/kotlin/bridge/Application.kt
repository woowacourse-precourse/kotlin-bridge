package bridge

fun main() {
    OutputView().printGameStart()

    val bridgeLength = InputView().readBridgeSize()
    val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
    val answerBridge = bridgeMaker.makeBridge(bridgeLength)

    var trial = 1
    BridgeGame().moveAndCheckAnswer(answerBridge, trial)
}