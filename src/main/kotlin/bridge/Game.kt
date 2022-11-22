package bridge

class Game {
    private lateinit var bridge: List<String>
    private val inputView = InputView()
    private val outputView = OutputView()
    private var bridgeGame = BridgeGame()
    private var success = true
    private var trycount = 1

    fun outputStartMessage() {
        if (trycount == 1) {
            outputView.printStartMessage()
        }
    }

    fun startGame() {
        while (true) {
            if (checkBridgeLength()) {
                break
            }
        }
    }

    private fun checkBridgeLength(): Boolean {
        try {
            inputBridgeLength()
        } catch (e: IllegalArgumentException) {
            outputView.printError(e.message.toString())
            return false
        }
        return true
    }

    private fun inputBridgeLength() {
        outputView.inputBridgeLength()
        val bridgeLength = inputView.readBridgeSize()
        if (InputValidator(bridgeLength).checkBridgeLengthException()) {
            bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeLength.toInt())
        }
    }

    fun crossTheBridge() {
        for (i in bridge.indices) {
            checkBridgeDirection(i)
            if (!success) {
                restartOrQuit()
                break
            }
        }
    }

    private fun checkBridgeDirection(index: Int) {
        try {
            outputView.inputDirection()
            inputDirection(index)
        } catch (e: IllegalArgumentException) {
            outputView.printError(e.message.toString())
            inputDirection(index)
        }
    }

    private fun inputDirection(index: Int) {
        val direction = inputView.readMoving()
        if (InputValidator(direction).checkDirectionException()) {
            verifyDirectionAndBridge(direction, index)
        }
    }

    private fun verifyDirectionAndBridge(direction: String, number: Int) {
        success = bridgeGame.move(direction, bridge[number])
        printResult()
    }

    private fun restartOrQuit() {
        while (true) {
            if (checkRestartOrQuit()) {
                break
            }
        }
    }

    private fun checkRestartOrQuit(): Boolean {
        try {
            if (inputRestartOrQuit()) backToBeginning()
        } catch (e: IllegalArgumentException) {
            outputView.printError(e.message.toString())
            return false
        }
        return true
    }

    private fun backToBeginning() {
        trycount++
        bridgeGame = BridgeGame()
        crossTheBridge()
    }

    private fun inputRestartOrQuit(): Boolean {
        outputView.inputRestartOrQuit()
        val restart = inputView.readGameCommand()
        if (InputValidator(restart).checkRestartOrQuitException()) {
            return BridgeGame().retry(restart)
        }
        return false
    }

    fun printFinalResult() {
        outputView.printFinalResult()
        printResult()
        outputView.printResult(success, trycount)
    }

    private fun printResult() {
        outputView.printMap(bridgeGame.upResult, bridgeGame.downResult)
    }

}