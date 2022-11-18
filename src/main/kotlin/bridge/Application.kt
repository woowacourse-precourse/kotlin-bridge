package bridge

fun gameManager() {
    val inputView = InputView()
    val outputView = OutputView()

    outputView.printBridge()
    val bridgeSize = inputView.readBridgeSize()
    val bridgeGame = BridgeGame(bridgeSize)
    val bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeSize)

    var position = 0
    while (bridgeGame.isContinue && position < bridgeSize) {
        outputView.printMove()
        val move = inputView.readMoving()
        bridgeGame.move(bridge, move, position)
        val triple = Triple(position, bridgeGame.getUpBridge(), bridgeGame.getDownBridge())
        outputView.printMap(triple)
        position++

        // 중간에 실패한 경우
        if (!bridgeGame.isContinue && position < bridgeSize) {
            outputView.printRetry()
            val retryCommand = inputView.readGameCommand()
            if (retryCommand == "R") {
                bridgeGame.retry()
                position = 0
            } else {
                outputView.printResult(triple, false)
                outputView.printTryNumber(bridgeGame.getRetryCounter())
                return
            }
        }
    }

    val triple = Triple(position-1, bridgeGame.getUpBridge(), bridgeGame.getDownBridge())
    outputView.printResult(triple, true)
    outputView.printTryNumber(bridgeGame.getRetryCounter())
}

fun main() {
    try {
        println("다리 건너기 게임을 시작합니다.")
        gameManager()
    } catch (e: IllegalArgumentException) {
        println(e.message)
        return
    }
}
