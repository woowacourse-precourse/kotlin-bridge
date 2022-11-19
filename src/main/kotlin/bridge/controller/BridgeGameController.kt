package bridge.controller

import bridge.BridgeMaker
import bridge.view.InputView
import bridge.view.OutputView

class BridgeGameController(
    private val bridgeMaker: BridgeMaker,
    private val inputView: InputView,
    private val outputView: OutputView
) {
    fun start() {}

    private fun setUp() {}

    private fun getBridgeSize(): Int {
        return 0
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
}