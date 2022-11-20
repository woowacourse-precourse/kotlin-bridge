package bridge.controller

import bridge.BridgeMaker
import bridge.BridgeRandomNumberGenerator
import bridge.domain.BridgeGame
import bridge.domain.BridgeGameInfo
import bridge.domain.BridgeGameStatus
import bridge.domain.BridgeGameStatus.FAILURE
import bridge.domain.BridgeGameStatus.RETRY
import bridge.domain.BridgeGameStatus.RUNNING
import bridge.view.InputView
import bridge.view.OutputView

class BridgeGameController {
    private val game by lazy { BridgeGame() }
    private val output by lazy { OutputView() }
    private val input by lazy { InputView() }

    private var status = RUNNING
    private val info = BridgeGameInfo(
        BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(input.readBridgeSize()),
        emptyList(),
        1
    )

    fun run() {
        while (status == RUNNING) {
            play()
            handleStatus()
        }
        output.printResult(info)
    }

    private fun play() {
        game.move(info, input.readMoving())
        output.printMap(info)
    }

    private fun handleStatus() {
        status = BridgeGameStatus.of(info)
        if (status == FAILURE) {
            status = BridgeGameStatus.of(input.readGameCommand())
        }
        if (status == RETRY) {
            game.retry(info)
            status = RUNNING
        }
    }
}
