package bridge

import Utils.Constants.RETRY

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame {
    private val gameManager = BridgeGameManager(0)
    private lateinit var bridgeMap: List<String>
    private var bridgeSize = 0

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     */
    fun start(bridgeSize: Int) {
        this.bridgeSize = bridgeSize
        bridgeMap = List(bridgeSize) { "" }
        bridgeMap = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeSize)
    }

    fun move(moving: String): Boolean {
        return gameManager.calculateIsMovable(bridgeMap, moving)
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     */
    fun retry(command: String): Boolean {
        if (command == RETRY)
            gameManager.retryInitial()

        return command == RETRY
    }

    fun arrivedEndOfBridge(): Boolean {
        return gameManager.calculateIsArrived(bridgeSize)
    }

    fun gameOver(isSuccess: Boolean) {
        gameManager.gameOver(bridgeMap, isSuccess)
    }

}
