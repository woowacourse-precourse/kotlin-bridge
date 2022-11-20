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
    private var status: BridgeGameStatus = RUNNING
    private var info: BridgeGameInfo

    init {
        status = RUNNING
        info = BridgeGameInfo(
            BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(InputView().readBridgeSize()),
            emptyList(),
            1
        )
    }
    fun run() {
        while (status == RUNNING) {
            play()
            handleStatus()
        }
        OutputView().printResult(info)
    }

    private fun play() {
        BridgeGame().move(info, InputView().readMoving())
        status = BridgeGameStatus.of(info)
        OutputView().printMap(info)
    }

    private fun handleStatus() {
        if (status == FAILURE) {
            status = BridgeGameStatus.of(InputView().readGameCommand())
        }
        if (status == RETRY) {
            info = BridgeGame().retry(info)
            status = RUNNING
        }
    }
}
