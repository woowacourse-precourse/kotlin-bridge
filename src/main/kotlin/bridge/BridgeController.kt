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
        if (bridgeGame.isEnd()) {
            output.printEndGame()
            output.printMap(bridgeGame.getUpSide(), bridgeGame.getDownSide())
            output.printResult(bridgeGame.getTryCount(), Enum.RESULT.SUCCESS.korean)
            return true
        }
        return false
    }

    private fun checkFail(): Boolean {
        if (bridgeGame.isFail()) {
            output.printRestart()
            if (checkRestart()) {
                return true
            }
        }
        return false
    }

    private fun checkRestart(): Boolean {
        when (input.readGameCommand()) {
            Enum.OPTION.RESTART.command -> bridgeGame.retry()
            Enum.OPTION.QUIT.command -> {
                output.printResult(bridgeGame.getTryCount(), Enum.RESULT.FAILURE.korean)
                return true
            }
        }
        return false
    }
}