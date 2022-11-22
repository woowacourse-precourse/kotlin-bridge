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
    val bridgeGame =  BridgeGame(bridge)
    print(bridge)
    playGame(bridgeGame)
    OutputView().printResult(bridgeGame)
}

fun generateBridge(): List<String> {
    OutputView().printStart()
    val bridgeSize = InputView().readBridgeSize()
    val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
    return bridgeMaker.makeBridge(bridgeSize)
}

fun playGame(bridgeGame: BridgeGame) {
    var isOnGame = true
    while (isOnGame) {
        playerMove(bridgeGame)
        if (bridgeGame.check() && bridgeGame.over()) {
            isOnGame = false
        }
        if (!bridgeGame.check()) {
            isOnGame = playerOnGame(bridgeGame)
        }
    }
}

fun playerOnGame(bridgeGame: BridgeGame): Boolean {
    OutputView().printRestart()
    val input = InputView().readGameCommand()
    if (input == "R") {
        bridgeGame.retry()
        return true
    }
    if (input == "Q") {
        return false
    }
    return true
}

fun playerMove(bridgeGame: BridgeGame) {
    OutputView().printUpOrDown()
    val moveState = InputView().readMoving()
    bridgeGame.move(moveState)
    OutputView().printMap(bridgeGame)
}