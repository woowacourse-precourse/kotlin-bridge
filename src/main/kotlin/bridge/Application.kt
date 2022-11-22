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
    val outputView: OutputView = OutputView()
    var count = 0
    while (bridgeGame.endGame()) {
        if(bridgeSize == count) return gameEnd(bridgeGame)
        val readMoving: String = InputView().readMoving()
        bridgeGame.move(readMoving)
        outputView.printMap(bridgeGame.getUpBridge(), bridgeGame.getDownBridge())
        count += 1
    }
    gameRestart(bridgeGame, bridgeSize)
}

fun gameEnd(bridgeGame: BridgeGame) {
    val outputView: OutputView = OutputView()
    println(ConstantMessage.BRIDGE_GAME_RESULT)
    outputView.printMap(bridgeGame.getUpBridge(), bridgeGame.getDownBridge())
    outputView.printResult(bridgeGame.getSuccessResult(), bridgeGame.getTotalCount())
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