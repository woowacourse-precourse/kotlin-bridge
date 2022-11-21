package bridge

fun main() {
    val input = InputView()
    val output = OutputView()
    // TODO(refactor): make class and sepearte by features
    output.printStartGame()
    val bridgeSize = input.readBridgeSize()
    val bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeSize)
    val bridgeGame = BridgeGame(bridge)
    var isSuccess = "실패"
    while (true) {
        output.printGetMoving()
        val bridgeMoving = input.readMoving()
        bridgeGame.move(bridgeMoving)
        output.printMap(bridgeGame)
        when (bridgeGame.isGameContinue()) {
            "CONTINUE" -> continue
            "SUCCESS" -> {
                isSuccess = "성공"
                break
            }
            "FAIL" -> { // TODO: make indent three
                output.printGameCommand()
                val restart = input.readGameCommand()
                if (restart == "R") bridgeGame.retry()
                else break
            }
        }
    }
    output.printResult(bridgeGame, isSuccess)
}
