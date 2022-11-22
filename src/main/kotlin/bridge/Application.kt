package bridge

fun main() {
    try {
        play()
    } catch (e: Exception) {
        println(e.message)
    }
}

fun play() {
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
        isSuccess = true
        count++
        for (position in bridge.indices) {
            if (!bridgeGame.move(InputView().readMoving(), position, bridge)) {
                outputView.printMap(bridgeGame.movings)
                isSuccess = false
                break
            }
            outputView.printMap(bridgeGame.movings)
        }
        if (!isSuccess)
            if (!bridgeGame.retry(InputView().readGameCommand())) break
    }
    outputView.printResult(bridgeGame.movings, isSuccess, count)
}
