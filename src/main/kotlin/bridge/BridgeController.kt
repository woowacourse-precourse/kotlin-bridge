package bridge

class BridgeController {
    private val bridgeRandomNumberGenerator = BridgeRandomNumberGenerator()
    private val input = InputView()
    private val output = OutputView()
    private val bridgeMaker = BridgeMaker(bridgeRandomNumberGenerator)
    private lateinit var bridgeGame: BridgeGame

    fun run() {
        makeBridge()
        gameProgress()
    }

    private fun makeBridge() {
        output.printStartGame()
        output.printInputSize()
        val bridgeSize = input.readBridgeSize()
        val bridges = bridgeMaker.makeBridge(bridgeSize)
        bridgeGame = BridgeGame(bridges)
    }

    private fun gameProgress() {
        while (true) {
            move()
            if (checkEnd() || checkFail())
                break
        }
    }

    private fun move() {
        output.printInputMove()
        val direction = input.readMoving()
        bridgeGame.move(direction)
        output.printMap(bridgeGame.getUpSide(), bridgeGame.getDownSide())
    }

    private fun checkEnd(): Boolean {
        if (bridgeGame.checkEnd()) {
            output.printEndGame()
            output.printMap(bridgeGame.getUpSide(), bridgeGame.getDownSide())
            output.printResult(bridgeGame.getTryCount(), "성공")
            return true
        }
        return false
    }

    private fun checkFail(): Boolean {
        if (bridgeGame.checkFail()) {
            output.printRestart()
            when (input.readGameCommand()) {
                "R" -> bridgeGame.retry()
                "Q" -> {
                    output.printResult(bridgeGame.getTryCount(), "실패")
                    return true
                }
            }
        }
        return false
    }
}