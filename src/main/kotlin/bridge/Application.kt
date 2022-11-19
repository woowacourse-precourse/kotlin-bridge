package bridge

fun main() {
    val inputView = InputView()
    val outputView = OutputView()

    outputView.printGameStart()

    outputView.printInputBridgeSize()
    val bridgeSize = inputView.readBridgeSize()
    val bridge = makeBridge(bridgeSize)
    val bridgeGame = BridgeGame(bridge)

    var tryCount = 0
    do {
        tryCount += 1
        outputView.printInputMoving()
        val moving = inputView.readMoving()
        val isFinished = bridgeGame.move(moving)
        outputView.printMap(bridgeGame.userMoving)
    } while (!isFinished || bridgeSize == bridgeGame.count)
}

private fun makeBridge(bridgeSize: Int): List<String> {
    val bridgeNumberGenerator = BridgeRandomNumberGenerator()
    val bridgeMaker = BridgeMaker(bridgeNumberGenerator)
    return bridgeMaker.makeBridge(bridgeSize)
}