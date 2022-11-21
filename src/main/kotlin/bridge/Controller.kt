package bridge

class Controller {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val inputCheck = InputCheck()

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
        inputCheck.checkBridgeLength(bridgeLength)
        return bridgeLength.toInt()
    }

    private fun chooseSpaceToMoveStep(length: Int) {
        outputView.printChooseSpaceToMove()
        val moveSpace = inputView.readMoving()
        inputCheck.checkChooseSpace(moveSpace)
    }

}