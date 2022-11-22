package bridge

class Controller {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val bridgeGame: BridgeGame
    private val bridge: List<String>
    private val bridgeLength: Int
    private var now = 0

    init {
        gameStartStep()
        bridgeLength = inputBridgeLengthStep()
        bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeLength)
        bridgeGame = BridgeGame(bridgeLength)
    }

    fun run() {
//        println(bridge)
        while (bridgeLength > now && checkProgressStatus()) {
            chooseSpaceToMoveStep()
            if (!checkProgressStatus()) {
                retryGameStep()
            }
            now++
        }
        outputView.printResult(bridgeGame, now)
    }

    private fun gameStartStep() {
        outputView.printGameStart()
    }

    private fun inputBridgeLengthStep(): Int {
        outputView.printInputBridgeLength()
        val bridgeLength = inputView.readBridgeSize()
        println()
        return bridgeLength.toInt()
    }

    private fun chooseSpaceToMoveStep() {
        val move = chooseSpace()
        bridgeGame.move(bridge, now, move)
        outputView.printMap(bridgeGame, now)
    }

    private fun chooseSpace(): String {
        outputView.printChooseSpaceToMove()
        return inputView.readMoving()
    }

    private fun checkProgressStatus(): Boolean {
        return bridgeGame.getProgressStatus()
    }

    private fun retryGameStep() {
        outputView.printRetry()
        val a = inputView.readGameCommand()
        if (a == "R") {
            bridgeGame.retry()
            now = -1
        }
    }
}