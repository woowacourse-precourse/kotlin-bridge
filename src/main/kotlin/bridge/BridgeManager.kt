package bridge

class BridgeManager {
    private val inputView = InputView()
    private val outputView = OutputView()
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
    }

    private fun retryChecker() {
        val retryCommand = getRetryCommand()
        if (retryCommand == InputView.COMMAND_RESTART) {
            this.restartGame()
        }
    }

    private fun restartGame() {
        this.bridgeGame.retry()
        this.position = -1
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

    private fun printGameResult(isSuccess: Boolean) {
        outputView.printResult(isSuccess, this.position - 1, this.bridgeGame)
        outputView.printTryNumber(this.bridgeGame.getRetryCounter())
    }

    fun gameLoop() {
        while (this.bridgeGame.getIsContinue() && this.position < this.bridgeSize) {
            this.moveBridge()
            if (!this.bridgeGame.getIsContinue()) {
                this.retryChecker()
            }
            this.position++
        }
        this.printGameResult(this.bridgeGame.getIsContinue())
    }

}
