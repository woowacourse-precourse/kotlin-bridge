package bridge

class BridgeManager(private val inputView: InputView, private val outputView: OutputView) {
    private val bridgeSize: Int
    private val bridge: List<String>
    private val bridgeGame: BridgeGame
    private var position = 0

    init {
        println(OutputView.PRINT_START)
        this.bridgeSize = this.setBridgeSize()
        this.bridgeGame = BridgeGame(this.bridgeSize)
        this.bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(this.bridgeSize)
    }

    private fun setBridgeSize(): Int {
        while (true) {
            try {
                this.outputView.printBridge()
                return this.inputView.readBridgeSize()
            } catch (e: IllegalArgumentException) {
                println(e.message)
                continue
            }
        }
    }

    private fun getMoveCommand(): String {
        while (true) {
            try {
                this.outputView.printMove()
                return inputView.readMoving()
            } catch (e: IllegalArgumentException) {
                println(e.message)
                continue
            }
        }
    }

    private fun moveBridge() {
        val move = getMoveCommand()
        this.bridgeGame.move(this.bridge, move, this.position)
        this.outputView.printMap(this.position, this.bridgeGame)
        this.position++
    }

    private fun failChecker(): Boolean {
        if (!this.bridgeGame.isContinue && this.position <  this.bridgeSize) {
            val retryCommand = getRetryCommand()
            if (retryCommand == "R") {
                this.restartGame()
            } else {
                this.quitGame()
                return true
            }
        }
        return false
    }

    private fun restartGame() {
        this.bridgeGame.retry()
        this.position = 0
    }

    private fun quitGame() {
        this.outputView.printResult(false, this.position-1, this.bridgeGame)
        this.outputView.printTryNumber(this.bridgeGame.getRetryCounter())
    }

    private fun getRetryCommand(): String {
        while (true) {
            try {
                this.outputView.printRetry()
                return this.inputView.readGameCommand()
            } catch (e: IllegalArgumentException) {
                println(e.message)
                continue
            }
        }
    }

    private fun printGameResult() {
        outputView.printResult(true, this.position-1, this.bridgeGame)
        outputView.printTryNumber(this.bridgeGame.getRetryCounter())
    }

    fun gameLoop() {
        while (this.bridgeGame.isContinue && this.position < this.bridgeSize) {
            this.moveBridge()
            if (this.failChecker()) {
                return
            }
        }
        this.printGameResult()
    }

}
