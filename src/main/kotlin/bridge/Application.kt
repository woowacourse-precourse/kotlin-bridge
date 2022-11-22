package bridge

fun main() {
    println(ConstantMessage.START_BRIDGE_GAME)
    val bridgeMaker: BridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
    val bridgeSize: Int = InputView().readBridgeSize()
    val bridge: List<String> = bridgeMaker.makeBridge(bridgeSize)
    val bridgeGame: BridgeGame = BridgeGame(bridge)
    gameStart(bridgeGame, bridgeSize)
}

fun gameStart(bridgeGame: BridgeGame, bridgeSize: Int) {
    var count = 0
    while (bridgeGame.endGame()) {
        if(bridgeSize == count) return gameEnd(bridgeGame)
        val readMoving: String = InputView().readMoving()
        bridgeGame.move(readMoving)
        bridgeGame.printMap()
        count += 1
    }
    gameRestart(bridgeGame, bridgeSize)
}

fun gameEnd(bridgeGame: BridgeGame) {
    println(ConstantMessage.BRIDGE_GAME_RESULT)
    bridgeGame.printMap()
    bridgeGame.printResult()
}

fun gameRestart(bridgeGame: BridgeGame, bridgeSize: Int) {
    when(InputView().readGameCommand()) {
        "R" -> {
            bridgeGame.retry()
            gameStart(bridgeGame, bridgeSize)
        }
        "Q" -> gameEnd(bridgeGame)
    }
}