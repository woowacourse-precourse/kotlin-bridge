package bridge.controller

import bridge.domain.BridgeGame
import bridge.domain.BridgeGameInfo
import bridge.domain.BridgeGameStatus
import bridge.domain.BridgeGameStatus.FAILURE
import bridge.domain.BridgeGameStatus.RETRY
import bridge.domain.BridgeGameStatus.RUNNING
import bridge.domain.BridgeMaker
import bridge.domain.BridgeRandomNumberGenerator
import bridge.view.InputView
import bridge.view.OutputView

class BridgeGameController {
    private var status: BridgeGameStatus = RUNNING
    private var info: BridgeGameInfo = BridgeGameInfo(emptyList(), emptyList(), 1)

    fun run() {
        info.bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(InputView().readBridgeSize())
        while (status == RUNNING) {
            info = BridgeGame().move(info, InputView().readMoving())
            status = BridgeGameStatus.getStatus(info)
            OutputView().printMap(info)
            handleStatus()
        }
        OutputView().printResult(info)
    }

    private fun handleStatus() {
        if (status == FAILURE) {
            status = BridgeGameStatus.setStatus(InputView().readGameCommand())
        }
        if (status == RETRY) {
            info = BridgeGame().retry(info)
            status = RUNNING
        }
    }
}
