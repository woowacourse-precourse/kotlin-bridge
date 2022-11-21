package bridge.controller

import bridge.BridgeMaker
import bridge.BridgeRandomNumberGenerator
import bridge.domain.Bridge
import bridge.domain.BridgeGame
import bridge.domain.Player
import bridge.utils.MOVING_FAILURE
import bridge.view.OutputView

class BridgeController {
    fun start() {
        OutputView().printGameStart()
        val size = InputController().getBridgeSize()
        val createdBridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(size)
        move(size, createdBridge)
    }

    private fun move(size: Int, createdBridge: List<String>) {
        while (player.isGameOver) {
            val direction = InputController().getBridgeMoving()
            val result = BridgeGame().move(bridge, direction, createdBridge)
            OutputView().printMap(bridge)
            retry(result)
            quit(size)
        }
    }

    private fun retry(result: String) {
        if (result == MOVING_FAILURE) {
            val command = InputController().getBridgeCommand()
            BridgeGame().retry(command, player, bridge)
        }
    }

    private fun quit(size: Int) {
        if (bridge.size == size || !player.isGameOver) {
            player.setGameQuit()
            OutputView().printResult(player, bridge, BridgeGame().isSuccess(player))
        }
    }

    companion object {
        private val bridge = Bridge()
        private val player = Player()
    }
}