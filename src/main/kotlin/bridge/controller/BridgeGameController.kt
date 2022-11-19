package bridge.controller

import bridge.BridgeMaker
import bridge.utils.BridgeValidator
import bridge.view.InputView
import bridge.view.OutputView
import java.lang.IllegalArgumentException

class BridgeGameController(
    private val bridgeMaker: BridgeMaker,
    private val inputView: InputView,
    private val outputView: OutputView
) {
    fun start() {
        outputView.printStartGame()
        outputView.printStepInterval()
        setUp()
    }

    private fun setUp() {}

    private fun getBridgeSize(): Int {
        var isValid = false
        val validator = BridgeValidator()
        var input = ""
        while (!isValid) {
            try {
                input = inputView.readBridgeSize()
                validator.validate(input)
                isValid = true
            } catch (e: IllegalArgumentException) {
                outputView.printErrorMessage(e.message ?: DEFAULT_ERROR_MESSAGE)
            }
        }
        return input.toInt()
    }

    private fun play() {}

    private fun getMovement(): String {
        return ""
    }

    private fun stop() {}

    private fun getGameCommand(): String {
        return ""
    }

    private fun restart() {}

    private fun finish() {}

    companion object {
        const val DEFAULT_ERROR_MESSAGE = "에러가 발생하였습니다."
    }
}