package bridge

fun main() {
    // TODO: 프로그램 구현
    OutputView().printGameStart()
    val bridge = BridgeGame(BridgeMaker(BridgeRandomNumberGenerator()), InputView().readBridgeSize())
    play(bridge)
}

fun play(bridge: BridgeGame) {
    val input = InputView()
    val output = OutputView()
    var count = 0
    while (!bridge.isFinished(count)) {
        bridge.move(input.readMoving(), count++)
        output.printMap(bridge.getCurBridge())
        if (bridge.isFailed()) { if (!bridge.retry(input.readGameCommand())) break else count = 0 }
    }
    output.printResult(bridge.getCurBridge(), bridge)
}