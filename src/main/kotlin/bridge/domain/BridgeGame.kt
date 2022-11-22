package bridge.domain

import bridge.domain.resource.GAME_END
import bridge.domain.resource.GAME_RESTART

class BridgeGame(
    private val gameManager: BridgeGameManager,
    private val bridgeMaker: BridgeMaker
) {
    private lateinit var bridge: List<String>

    fun runGame() {
        gameManager.startGame()
        val bridgeSize = gameManager.getBridgeSize()
        bridge = bridgeMaker.makeBridge(bridgeSize)

        move()
    }

    fun move() {
        val path = mutableListOf<String>()

        for (i in bridge.indices) {
            val movement = gameManager.getMovement()
            path.add(movement)

            gameManager.printMap(path, bridge)

            if(movement != bridge[i]) {
                retry()
                break
            }
        }

        // TODO: 다리 건너기 성공
    }

    fun retry() {
        val command = gameManager.getRestartCommand()

        when (command) {
            GAME_RESTART -> move()
        //    GAME_END -> // TODO: 다리 건너기 실패
        }
    }
}
