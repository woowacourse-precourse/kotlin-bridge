package bridge

class GameManager {
    private val inputView = InputView()
    private val outputView = OutputView()
    private var bridgeGame: BridgeGame
    private var bridge = listOf<String>()
    private var bridgeSize: Int
    private var position = 0

    init {
        printStartMessage()
        bridgeSize = inputView.readBridgeSize()
        bridgeGame = BridgeGame(bridgeSize)
        bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeSize)
    }


    fun play() {
        while (bridgeGame.isSuccess && position < bridgeSize) {
            val move = inputView.readMoving()
            bridgeGame.move(bridge, move, position)
            outputView.printMap(bridgeGame)
            if (!bridgeGame.isSuccess) {
                val retryCommand = inputView.readGameCommand()
                if (retryCommand == "R") {
                    restartGame()
                }
            }
            position++
        }
        printEndGame(bridgeGame.isSuccess)
    }

    private fun printEndGame(isSuccess: Boolean) {
        outputView.printResult(bridgeGame, isSuccess, position - 1)
        outputView.printTryNumber(bridgeGame.tryCounter)
    }

    private fun restartGame() {
        bridgeGame.retry()
        position = -1
    }

    private fun printStartMessage() = println(START_MESSAGE)

    companion object {
        const val START_MESSAGE = "다리 건너기 게임을 시작합니다."
    }
}