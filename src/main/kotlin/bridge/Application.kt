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
        game.move(bridge, InputView().readMoving())
        OutputView().printMap(game.getUpBridge(), game.getDownBridge())
    }
    if (game.getSuccessResult()) end(game) else reStart(game, bridge)
}

fun end(game: BridgeGame) {
    OutputView().printResult()
    OutputView().printMap(game.getUpBridge(), game.getDownBridge())
    OutputView().printResultIsSuccess(game.getSuccessResult(), game.getTotalCount())
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