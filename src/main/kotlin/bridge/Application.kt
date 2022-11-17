package bridge

fun main() {
    start()
}

private fun start() {
    OutputView().printStart()
    val inputReadBridgeSize: Int = InputView().readBridgeSize()
    val bridgeMaker: BridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
    val bridge = bridgeMaker.makeBridge(inputReadBridgeSize)
    val bridgeGame: BridgeGame = BridgeGame()
    play(bridgeGame, bridge)
}

fun play(game: BridgeGame, bridge: List<String>) {
    while (!game.isGameEnd(bridge)) {
        game.move(bridge[game.count], InputView().readMoving())
        OutputView().printMap(game.upBridge, game.downBridge)
    }
    if (game.isSuccess) end(game) else reStart(game, bridge)
}

fun end(game: BridgeGame) {
    OutputView().printResult()
    OutputView().printMap(game.upBridge, game.downBridge)
    OutputView().printResultIsSuccess(game.isSuccess, game.totalCount)
}

fun reStart(game: BridgeGame, bridge: List<String>) {
    when (InputView().readGameCommand()) {
        "R" -> {
            game.retry()
            play(game, bridge)
        }
        "Q" -> end(game)
    }
}