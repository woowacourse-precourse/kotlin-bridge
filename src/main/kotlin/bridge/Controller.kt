package bridge

class Controller {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun run() {
        gameStartStep()
        val bridgeLength = inputBridgeLengthStep()
    }

    private fun gameStartStep() {
        outputView.printGameStart()
    }

    private fun inputBridgeLengthStep(): Int {
        outputView.printInputBridgeLength()
        return inputView.readBridgeSize()
    }
}