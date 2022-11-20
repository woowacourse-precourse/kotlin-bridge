package bridge

import camp.nextstep.edu.missionutils.Console

class Controller {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val inputCheck = InputCheck()

    fun run() {
        gameStartStep()
        val bridgeLength = inputBridgeLengthStep()
    }

    private fun gameStartStep() {
        outputView.printGameStart()
    }

    private fun inputBridgeLengthStep(): Int {
        outputView.printInputBridgeLength()
        val bridgeLength = inputView.readBridgeSize()
        outputView.printBridgeLength(bridgeLength)
        inputCheck.checkBridgeLength(bridgeLength)
        return bridgeLength.toInt()
    }
}