package bridge.domain

import bridge.domain.resource.GAME_END
import bridge.domain.resource.GAME_RESTART
import bridge.domain.resource.MoveType

class BridgeGame(
    private val gameManager: BridgeGameManager,
    private val bridgeMaker: BridgeMaker
) {
    private lateinit var bridge: List<String>
    private lateinit var path: MutableList<String>
    private var gameResult = true
    private var numberOfTry = 0

    fun runGame() {
        gameManager.startGame()
        setBridge(gameManager.getBridgeSize())
        crossBridge()
        gameManager.endGame(getMap(), gameResult, numberOfTry)
    }

    fun setBridge(bridgeSize: Int) {
        bridge = bridgeMaker.makeBridge(bridgeSize)
    }

    fun resetValues() {
        path = mutableListOf()
    }

    private fun crossBridge() {
        numberOfTry++
        resetValues()
        var isMoving = true

        while (isMoving && path.size < bridge.size) {
            isMoving = move(gameManager.getMovement())
        }
    }

    private fun move(movement: String): Boolean {
        updateMovingPath(movement)

        val isSuccess = isSuccessMoving(movement, path.size - 1)
        if (!isSuccess) {
            retry()
        }

        return isSuccess
    }

    fun updateMovingPath(movement: String) {
        path.add(movement)
        gameManager.printMap(getMap())
    }

    fun isSuccessMoving(movement: String, index: Int): Boolean {
        if (movement != bridge[index]) {
            return false
        }

        return true
    }

    private fun retry() {
        when (gameManager.getRestartCommand()) {
            GAME_RESTART -> crossBridge()
            GAME_END -> gameResult = false
        }
    }

    fun getMap(): List<List<String>> {
        return MoveType.getAllMap(path, bridge)
    }
}
