package bridge.controller

import bridge.AVAILABLE_PATH
import bridge.NOT_INITIALIZED
import bridge.RETRY_INPUT
import bridge.UNAVAILABLE_PATH
import bridge.model.BridgeGame
import bridge.model.data.Direction
import bridge.model.data.GameStatus
import bridge.model.data.PlayerStatus
import bridge.view.InputView
import bridge.view.OutputView

class Processor(
    private val bridgeGame: BridgeGame,
    private val inputView: InputView,
    private val outputView: OutputView,
) {
    private var numberOfTry = 1
    private lateinit var playerPathMap: Array<String>
    private val bridgeSize: Int by lazy {
        inputView.readBridgeSize()
    }

    fun processGame() {
        lateinit var gameStatus: GameStatus
        initBridge()
        do {
            val playerStatus = move()
            recordPlayerMoving(playerStatus)
            outputView.printMap(playerPathMap)
            gameStatus = bridgeGame.checkGameStatus(playerStatus.isPlayerAlive)
        } while (checkContinuing(gameStatus) == GameStatus.CONTINUING)
        finish(gameStatus)
    }

    private fun move(): PlayerStatus {
        val playerDirection = inputView.readMoving()
        val playerStatus = bridgeGame.move(playerDirection)

        return playerStatus
    }

    /**
     * 이동 경로를 최신화 하기 위한 함수
     */
    private fun recordPlayerMoving(playerStatus: PlayerStatus) {
        var recordSign = AVAILABLE_PATH
        if (!playerStatus.isPlayerAlive) {
            recordSign = UNAVAILABLE_PATH
        }
        playerPathMap[playerStatus.playerDirection] =
            playerPathMap[playerStatus.playerDirection].replaceFirst("N", recordSign)
        playerPathMap[playerStatus.playerDirection.oppositeDirection()] =
            playerPathMap[playerStatus.playerDirection.oppositeDirection()].replaceFirst("N", " ")
    }

    private fun checkContinuing(gameStatus: GameStatus): GameStatus {
        if (gameStatus == GameStatus.FAILED) {
            if (checkRetry()) {
                initForRetry()
                return GameStatus.CONTINUING
            }
        }
        return gameStatus
    }

    private fun initPathMap(bridgeSize: Int) {
        playerPathMap = Array(2) { NOT_INITIALIZED.repeat(bridgeSize) }
    }

    private fun initBridge() {
        bridgeGame.initBridge(bridgeSize)
        initPathMap(bridgeSize)
    }

    private fun initForRetry() {
        numberOfTry++
        initPathMap(bridgeSize)
        bridgeGame.retry()
    }

    private fun checkRetry(): Boolean = RETRY_INPUT == inputView.readGameCommand()

    private fun finish(gameStatus: GameStatus) {
        outputView.printResult(playerPathMap, numberOfTry, gameStatus)
    }

    private fun Int.oppositeDirection() = if (this == Direction.UP.directionNumber) {
        Direction.DOWN.directionNumber
    } else {
        Direction.UP.directionNumber
    }


}