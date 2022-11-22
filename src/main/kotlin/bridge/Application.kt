package bridge


fun main() {
    // TODO: 프로그램 구현
    val bridgeMade = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(InputView().readBridgeSize())
    RunGame().gameMaker(bridgeMade)
}

