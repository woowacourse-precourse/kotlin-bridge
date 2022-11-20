package bridge.controller

import bridge.domain.BridgeGame
import bridge.domain.BridgeGameInfo
import bridge.domain.BridgeGameStatus
import bridge.domain.BridgeGameStatus.FAILURE
import bridge.domain.BridgeGameStatus.RETRY
import bridge.domain.BridgeGameStatus.RUNNING
import bridge.domain.User
import bridge.view.OutputView

class BridgeGameController {
    private var status: BridgeGameStatus = RUNNING
    private var info = BridgeGameInfo(BridgeGame().build(), emptyList(), 1)

    fun run() {
        while (status == RUNNING) {
            info = BridgeGame().move(info)
            status = BridgeGameStatus.getStatus(info)
            OutputView().printMap(info)
            handleStatus()
        }
        OutputView().printResult(info)
    }

    private fun handleStatus() {
        if (status == FAILURE) {
            status = BridgeGameStatus.setStatus(User().inputGameCommand())
        }
        if (status == RETRY) {
            info = BridgeGame().retry(info)
            status = RUNNING
        }
    }
}
