package bridge

class BridgeManager(private val inputView: InputView, private val outputView: OutputView) {
    private val bridgeSize: Int
    private val bridge: List<String>
    private val bridgeGame: BridgeGame
    private var position = 0

    init {
        println("다리 건너기 게임을 시작합니다.")
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

    fun moveBridge() {
        val move = getMoveCommand()
        this.bridgeGame.move(this.bridge, move, this.position)
        val triple = Triple(this.position, this.bridgeGame.getUpBridge(), this.bridgeGame.getDownBridge())
        this.outputView.printMap(triple)
        this.position++
    }

    fun failChecker(): Boolean {
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
        val triple = Triple(this.position, this.bridgeGame.getUpBridge(), this.bridgeGame.getDownBridge())
        this.outputView.printResult(triple, false)
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

    fun getBridgeSize() = this.bridgeSize

    fun getBridge() = this.bridge

    fun getBridgeGame() = this.bridgeGame

    fun getPosition() = this.position

}