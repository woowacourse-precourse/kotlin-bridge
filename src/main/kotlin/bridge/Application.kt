package bridge

fun main() {
    println("다리 건너기 게임을 시작합니다.")
    var bridgeLength = InputView().readBridgeSize()
    var bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
    var bridge = bridgeMaker.makeBridge(bridgeLength)

    var bridgeGame = BridgeGame()
    bridgeGame.move(bridge)
}
