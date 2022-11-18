package bridge

fun main() {
    println("다리 건너기 게임을 시작합니다.\n")

    val bridgeLength = InputView().readBridgeSize()
    val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
    val answerBridge = bridgeMaker.makeBridge(bridgeLength)

    var trial = 1
    BridgeGame().move(answerBridge, trial)
}