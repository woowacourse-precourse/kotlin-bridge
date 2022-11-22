package bridge

class GameManager {
    private val inputView = InputView()
    private val outputView = OutputView()
    private var bridgeGame: BridgeGame
    private var bridge = listOf<String>()
    private var bridgeSize: Int
    private var position = INIT

    init {
        printStartMessage()
        bridgeSize = setBridgeSize()
        bridgeGame = BridgeGame(bridgeSize)
        bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeSize)
    }

    fun play() {
        while (bridgeGame.isSuccess && position < bridgeSize) {
            val move = setMove()
            checkBridge(move)
            checkGameEnd()
            position++
        }
        printEndGame(bridgeGame.isSuccess)
    }

    private fun checkBridge(move: String) {
        bridgeGame.move(bridge, move, position)
        outputView.printMap(bridgeGame)
    }

    private fun checkGameEnd() {
        if (!bridgeGame.isSuccess) {
            val retryCommand = setGameCommand()
            checkRetry(retryCommand)
        }
    }

    private fun checkRetry(retryCommand: String) {
        if (retryCommand == RETRY) restartGame()
    }

    private fun setBridgeSize(): Int {
        while (true) {
            try {
                return inputView.readBridgeSize()
            } catch (e: IllegalArgumentException) {
                println(e.message)
                continue
            }
        }
    }

    private fun setMove(): String {
        while (true) {
            try {
                return inputView.readMoving()
            } catch (e: IllegalArgumentException) {
                println(e.message)
                continue
            }
        }
    }

    private fun setGameCommand(): String {
        while (true) {
            try {
                return inputView.readGameCommand()
            } catch (e: IllegalArgumentException) {
                println(e.message)
                continue
            }
        }
    }

    private fun printEndGame(isSuccess: Boolean) {
        outputView.printResult(bridgeGame, isSuccess, bridgeGame.tryCounter)
    }

    private fun restartGame() {
        bridgeGame.retry()
        position = INIT_RETRY
    }

    private fun printStartMessage() = println(START_MESSAGE)

    companion object {
        const val START_MESSAGE = "다리 건너기 게임을 시작합니다."
        const val RETRY = "R"
        const val INIT = 0
        const val INIT_RETRY = -1
    }
}