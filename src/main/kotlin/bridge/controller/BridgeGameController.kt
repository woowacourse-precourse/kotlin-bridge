package bridge.controller

import bridge.BridgeMaker
import bridge.BridgeRandomNumberGenerator
import bridge.domain.BridgeGame
import bridge.domain.BridgeGameCommand
import bridge.domain.BridgeGameCommand.NONE
import bridge.domain.BridgeGameCommand.RETRY
import bridge.domain.BridgeGameInfo
import bridge.domain.BridgeGameProgress
import bridge.domain.BridgeGameProgress.FAILURE
import bridge.domain.BridgeGameProgress.RUNNING
import bridge.view.InputView
import bridge.view.OutputView

class BridgeGameController {
    private val game by lazy { BridgeGame() }
    private val output by lazy { OutputView() }
    private val input by lazy { InputView() }

    private var progress = RUNNING
    private var command = NONE
    private val info = BridgeGameInfo(
        BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(input.readBridgeSize()),
        emptyList(),
        1
    )

    fun run() {
        while (progress == RUNNING) {
            play()
            handleProgress()
            handleCommand()
        }
        output.printResult(info)
    }

    private fun play() {
        game.move(info, input.readMoving())
        output.printMap(info)
    }

    private fun handleProgress() {
        progress = BridgeGameProgress.of(info)
        if (progress == FAILURE) {
            command = BridgeGameCommand.of(input.readGameCommand())
        }
    }
    private fun handleCommand() {
        if (command == RETRY) {
            game.retry(info)
            command = NONE
            progress = RUNNING
        }
    }
}
