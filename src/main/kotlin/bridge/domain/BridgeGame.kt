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
    var gameResult = true
    var numberOfTry = 0

    fun runGame() {
        gameManager.startGame()
        val bridgeSize = gameManager.getBridgeSize()
        bridge = bridgeMaker.makeBridge(bridgeSize)

        crossBridge()
        gameManager.endGame(getMap(), gameResult, numberOfTry)
    }

    fun crossBridge() {
        numberOfTry++

        path = mutableListOf()
        var isMoving = true
        var currentIndex = 0

        while (isMoving && currentIndex < bridge.size) {
            isMoving = move(currentIndex++, gameManager.getMovement())
        }
    }

    fun move(currentIndex: Int, movement: String): Boolean {
        path.add(movement)
        gameManager.printMap(getMap())

        if (!isSuccessMoving(movement, currentIndex)) {
            retry()
            return false
        }

        return true
    }

    fun isSuccessMoving(movement: String, index: Int): Boolean {
        if (movement != bridge[index]) {
            return false
        }

        return true
    }

    fun retry() {
        when (gameManager.getRestartCommand()) {
            GAME_RESTART -> crossBridge()
            GAME_END -> gameResult = false
        }
    }

    fun getMap(): List<List<String>> {
        return MoveType.getAllMap(path, bridge)
    }
}
