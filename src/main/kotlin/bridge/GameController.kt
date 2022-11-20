package bridge

class GameController {

    private var size = ZERO
    init {
        OutputView.startGame()
        getBridgeLength()
    }

    fun start() {
    }

    private fun getBridgeLength() {
        while (true) {
            try {
                OutputView.inputLength()
                size = InputView.readBridgeSize()
                break
            } catch (e: Exception) {
                println("$ERROR ${e.message}\n")
            }
        }
    }
}