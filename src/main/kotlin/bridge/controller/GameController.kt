package bridge.controller

import bridge.BridgeGame
import bridge.BridgeMaker
import bridge.BridgeRandomNumberGenerator
import bridge.domain.Bridge
import bridge.domain.BridgeState
import bridge.ui.InputView
import bridge.ui.OutputView

class GameController {
    private val inputView = InputView()
    private val outputView = OutputView()
    private var bridgeState = BridgeState()
    private var isSuccess = FAIL
    private var command = RETRY
    private var count = 0

    companion object {
        const val SUCCESS = "성공"
        const val FAIL = "실패"
        const val RETRY = true
        const val QUIT = false
    }

    fun playGame() {
        outputView.printGameStart()
        val size = inputView.readBridgeSize()
        val bridgeRandomNumberGenerator = BridgeRandomNumberGenerator()
        val blocks = BridgeMaker(bridgeRandomNumberGenerator).makeBridge(size)
        val bridge = Bridge(blocks)
        crossBridge(bridge)
    }

    private fun crossBridge(bridge: Bridge) {
        while (command && isSuccess == FAIL) {
            bridgeState = BridgeState()
            count++
            if (bridgeState.compare(bridge)) {
                isSuccess = SUCCESS
                break
            }
            if (!BridgeGame().retry(inputView.readGameCommand())) command = QUIT
        }
        bridgeState.endGame(count, isSuccess)
    }
}