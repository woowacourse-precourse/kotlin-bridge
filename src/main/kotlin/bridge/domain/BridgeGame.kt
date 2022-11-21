package bridge.domain

import bridge.domain.resource.GAME_END
import bridge.domain.resource.GAME_RESTART

class BridgeGame(
    private val gameManager: BridgeGameManager,
    private val bridgeMaker: BridgeMaker
) {
    fun runGame() {
        gameManager.startGame()
        val bridgeSize = gameManager.getBridgeSize()
        val bridge = bridgeMaker.makeBridge(bridgeSize)

        move(bridge)
    }

    fun move(bridge: List<String>) {
        val path = mutableListOf<String>()

        for (i in bridge.indices) {
            val movement = gameManager.getMovement()
            path.add(movement)

            gameManager.printMap(path, bridge)

            if(movement != bridge[i]) {
                retry(bridge)
                break
            }
        }

        // TODO: 다리 건너기 성공
    }

    fun retry(bridge: List<String>) {
        val command = gameManager.getRestartCommand()

        when (command) {
            GAME_RESTART -> move(bridge)
        //    GAME_END ->
        }
    }
}
