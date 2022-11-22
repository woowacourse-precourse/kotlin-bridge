package bridge


fun main() {
    startBridgeGame()
}

fun startBridgeGame() {
    val input = InputView()
    val bridge = generateBridge(input)
    val output = OutputView(bridge)
    val game = BridgeGame()

    while (true) {
        moveForward(game, input, output)
        if (output.getWrongStatus() == 1) getCommand(game, input, output)
        if (game.getMovingRecord().size == output.getBridge().size) break
    }
    output.printResult()
}

fun generateBridge(inputView: InputView): List<String> {
    val numberGenerator = BridgeRandomNumberGenerator()
    val maker = BridgeMaker(numberGenerator)
    val bridge = maker.makeBridge(inputView.readBridgeSize())
    println(bridge)
    return bridge
}

fun moveForward(game: BridgeGame, input: InputView, output: OutputView) {
    while (output.getWrongStatus() != 1
            && game.getMovingRecord().size != output.getBridge().size
    ) {
        game.move(input.readMoving())
        output.printMap(game.getMovingRecord())
    }
}

fun retryGame(game: BridgeGame, input: InputView, output: OutputView) {
    game.retry()
    output.printMap(game.getMovingRecord())   // map 초기화
    moveForward(game, input, output)
}

fun getCommand(game: BridgeGame, input: InputView, output: OutputView) {
    when (input.readGameCommand()) {
        ValidationInput.RETRY_GAME_VALUE -> retryGame(game, input, output)
        ValidationInput.QUIT_GAME_VALUE -> output.printResult()
    }
}








