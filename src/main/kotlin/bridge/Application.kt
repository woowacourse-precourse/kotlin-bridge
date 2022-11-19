package bridge

private val inputView = InputView()
private val outputView = OutputView()

fun main() {
    outputView.printGameStart()
    outputView.printInputBridgeSize()
    val bridgeSize = inputView.readBridgeSize()
    val bridge = makeBridge(bridgeSize)
    val bridgeGame = BridgeGame(bridge)

    startGame(bridgeGame, bridgeSize)
}

private fun startGame(bridgeGame: BridgeGame, bridgeSize: Int) {
    var isFail: Boolean
    do {
        isFail = moveSpace(bridgeGame)
    } while (getFinishState(isFail, bridgeGame, bridgeSize).not())

    outputView.printResult(isFail, bridgeGame.tryCount, bridgeGame.userMoving)
}

private fun moveSpace(bridgeGame: BridgeGame): Boolean {
    outputView.printInputMoving()
    val moving = inputView.readMoving()
    val isFail = bridgeGame.move(moving)
    outputView.printMap(bridgeGame.userMoving)

    return isFail
}

private fun getFinishState(isFail: Boolean, bridgeGame: BridgeGame, bridgeSize: Int): Boolean {
    var isFinished = bridgeSize == bridgeGame.colPosition
    if (isFail) {
        outputView.printGameCommand()
        val command = inputView.readGameCommand()
        isFinished = isFinished(command)
        if (isFinished.not()) {
            bridgeGame.retry()
        }
    }

    return isFinished
}

private fun makeBridge(bridgeSize: Int): List<String> {
    val bridgeNumberGenerator = BridgeRandomNumberGenerator()
    val bridgeMaker = BridgeMaker(bridgeNumberGenerator)
    return bridgeMaker.makeBridge(bridgeSize)
}

private fun isFinished(command: String): Boolean {
    if (command == "R") {
        return false
    }

    return true
}