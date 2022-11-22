package bridge

fun main() {
    try {
        playBridgeGame()
    } catch (e: Exception) {
        println(e.message)
    }
}

fun playBridgeGame() {
    println("다리 건너기 게임을 시작합니다.\n")
    val bridge = generateBridge()
    val bridgeGame = BridgeGame()
    val outputView = OutputView(bridge)
    progressBridgeGame(bridgeGame, outputView, bridge)
}

fun generateBridge(): List<String> {
    val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
    val bridgeSize = InputView().readBridgeSize()
    return bridgeMaker.makeBridge(bridgeSize)
}

fun progressBridgeGame(bridgeGame: BridgeGame, outputView: OutputView, bridge: List<String>) {
    var count = 0
    var isSuccess = false
    while (!isSuccess) {
        bridgeGame.clearMovings()
        count++
        isSuccess = isBridgeGameSuccess(bridgeGame, outputView, bridge)
        if (!isSuccess && !bridgeGame.retry(InputView().readGameCommand())) break
    }
    outputView.printResult(bridgeGame.moves, isSuccess, count)
}

fun isBridgeGameSuccess(bridgeGame: BridgeGame, outputView: OutputView, bridge: List<String>): Boolean {
    for (position in bridge.indices) {
        if (!bridgeGame.move(InputView().readMoving(), position, bridge)) {
            outputView.printMap(bridgeGame.moves)
            return false
        }
        outputView.printMap(bridgeGame.moves)
    }
    return true
}
