package bridge

fun main() {
    start()
}

private fun start() {
    OutputView().printStart()
    val inputReadBridgeSize: Int = InputView().readBridgeSize()
    val bridgeMaker: BridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
    val bridge : List<String> = bridgeMaker.makeBridge(inputReadBridgeSize)
    val bridgeGame: BridgeGame = BridgeGame(bridge)
    play(bridgeGame)
}

fun play(game: BridgeGame) {
    while (!game.isGameEnd()) {
        game.move(InputView().readMoving())
        OutputView().printMap(game.getUpBridge(), game.getDownBridge())
    }
    if (game.getSuccessResult()) end(game) else reStart(game)
}

fun end(game: BridgeGame) {
    OutputView().printResult()
    OutputView().printMap(game.getUpBridge(), game.getDownBridge())
    OutputView().printResultIsSuccess(game.getSuccessResult(), game.getTotalCount())
}

fun reStart(game: BridgeGame) {
    when (InputView().readGameCommand()) {
        Constant.REPLAY -> {
            game.retry()
            play(game)
        }

        Constant.QUIT -> end(game)
    }
}