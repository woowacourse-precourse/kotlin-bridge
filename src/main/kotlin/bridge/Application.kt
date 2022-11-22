package bridge

fun main() {
    val input=InputView()
    val output=OutputView()

    println("다리 건너기 게임을 시작합니다.\n")
    val bridgeGame = BridgeGame(BridgeMaker(BridgeRandomNumberGenerator()), input.readBridgeSize())
    moveBlock(bridgeGame, input, output)
}

fun moveBlock(bridgeGame: BridgeGame, input: InputView, output: OutputView) {
    println()
    while(!bridgeGame.isEnd()) {
        bridgeGame.move(input.readMoving())
        output.printMap(bridgeGame)
    }

    isSuccessGame(bridgeGame, input, output)
}

fun isSuccessGame(bridgeGame: BridgeGame, input: InputView, output: OutputView) {
    if(bridgeGame.isSuccess()) {
        output.printResult(bridgeGame)
        return
    }

    isRetry(bridgeGame, input, output)
}


fun isRetry(bridgeGame: BridgeGame, input: InputView, output: OutputView) {
    when(input.readGameCommand()) {
        "R" -> {
            bridgeGame.retry()
            moveBlock(bridgeGame, input, output)
        }
        "Q" -> {
            output.printResult(bridgeGame)
        }
    }
}


