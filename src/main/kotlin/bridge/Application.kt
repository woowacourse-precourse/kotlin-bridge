package bridge

fun main() {
    playBridgeGame()
}

fun playBridgeGame() {
    val input = InputView()
    val output = OutputView()
    output.printStart()
    val game = BridgeGame(BridgeMaker(BridgeRandomNumberGenerator()), input.readBridgeSize())
    playGame(game, input, output)
}

fun playOneGame(game: BridgeGame, input: InputView, output: OutputView) {
    while (!game.isGameEnd()) {
        game.move(input.readMoving())
        output.printMap(game)
    }
}

fun playGame(game: BridgeGame, input: InputView, output: OutputView) {
    playOneGame(game, input, output)
    if (game.isSuccess()) {
        output.printResult(game)
        return
    }
    when(input.readGameCommand()) {
        "R" -> {
            game.retry()
            playGame(game, input, output)
        }
        "Q" -> { output.printResult(game) }
    }
}