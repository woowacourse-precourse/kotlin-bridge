package bridge.domain

import bridge.domain.resource.GAME_END
import bridge.domain.resource.GAME_RESTART
import bridge.domain.resource.MoveType

class BridgeGame(
    private val gameManager: BridgeGameManager,
    private val bridgeMaker: BridgeMaker
) {
    lateinit var bridge: List<String>
    lateinit var path: MutableList<String>

    fun runGame() {
        gameManager.startGame()
        val bridgeSize = gameManager.getBridgeSize()
        bridge = bridgeMaker.makeBridge(bridgeSize)

        crossBridge()
    }

    fun crossBridge() {
        path = mutableListOf()
        var isMoving = true
        var currentIndex = 0

        while (isMoving) {
            isMoving = move(currentIndex++)
        }
    }

    fun move(currentIndex: Int): Boolean {
        if (currentIndex == bridge.size) {
            return false // TODO: 다리 건너기 성공
        }

        val movement = gameManager.getMovement()
        path.add(movement)
        gameManager.printMap(getMap())

        return isSuccessMoving(movement, currentIndex)
    }

    fun isSuccessMoving(movement: String, index: Int): Boolean {
        if (movement != bridge[index]) {
            retry()
            return false
        }

        return true
    }

    fun retry() {
        val command = gameManager.getRestartCommand()

        when (command) {
            GAME_RESTART -> crossBridge()
            //    GAME_END -> // TODO: 다리 건너기 실패
        }
    }

    fun getMap(): List<List<String>> {
        return MoveType.getAllMap(path, bridge)
    }
}
