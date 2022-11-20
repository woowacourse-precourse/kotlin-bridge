package bridge.controller

import bridge.BridgeMaker
import bridge.BridgeRandomNumberGenerator
import bridge.domain.Bridge
import bridge.domain.BridgeGame
import bridge.domain.Player
import bridge.view.OutputView

class BridgeController {
    fun start() {
        OutputView().printGameStart()
        val size = InputController().getBridgeSize()
        val createdBridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(size)
        move(size, createdBridge)
    }

    fun move(size: Int, createdBridge: List<String>) {
        while (player.isGameOver) {
            val direction = InputController().getBridgeMoving()
            val result = BridgeGame().move(bridge, direction, createdBridge)
            OutputView().printMap(bridge)
            retry(result)
            if (bridge.size == size || !player.isGameOver) {
                quit()
            }
        }
    }

    fun retry(result: String) {
        if (result == "X") {
            val command = InputController().getBridgeCommand()
            BridgeGame().retry(command, player, bridge)
        }
    }

    fun quit() {
        player.setGameQuit()
        OutputView().printResult(player, bridge, BridgeGame().isSuccess(player))
    }

    companion object {
        private val bridge = Bridge()
        private val player = Player()
    }
}