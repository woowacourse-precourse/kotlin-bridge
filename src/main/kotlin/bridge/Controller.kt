package bridge

class Controller {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun run() {
        gameStartStep()
        val bridgeLength = inputBridgeLengthStep()
        chooseSpaceToMoveStep(bridgeLength)
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

    private fun chooseSpaceToMoveStep(length: Int) {
        outputView.printChooseSpaceToMove()
        val moveSpace = inputView.readMoving()
    }

}