package bridge

fun main() {
    try {
        start()
    } catch (e: IllegalArgumentException) {
        return
    }
}

fun start() {
    val bridge = generateBridge()
    playGame(bridge)
}

fun generateBridge(): List<String> {
    OutputView.printStart()
    val bridgeSize = InputView().readBridgeSize()
    val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
    return bridgeMaker.makeBridge(bridgeSize)
}

fun playGame(bridge: List<String>) {
    val bridgeGame =  BridgeGame(bridge)
    var isOnGame = true
    while (isOnGame) {
        playerMove(bridgeGame)
        isOnGame = playerOnGame(bridgeGame)
    }
    OutputView().printResult(bridgeGame)
}


