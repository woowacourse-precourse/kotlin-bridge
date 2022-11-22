package bridge.model

import bridge.MovingEventManager
import bridge.QuitEventManager

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(private val movingEventManager: MovingEventManager, private val quitEventManager: QuitEventManager) {
    private lateinit var bridge: List<String>
    private var userHistory = mutableListOf<String>()
    private lateinit var gameStatus: GameStatus
    private var attempts: Int = 0

    fun start(bridge: List<String>) {
        require(!started()) { "[ERROR] 게임은 한 번만 시작할 수 있습니다." }
        validateBridge(bridge)
        this.bridge = bridge
        userHistory.clear()
        gameStatus = GameStatus.RUNNING
        attempts++
    }

    private fun started(): Boolean = ::bridge.isInitialized

    private fun validateBridge(bridge: List<String>) =
        require(bridge.size in 3..20 && bridge.all { it == "U" || it == "D" }) { "다리의 길이는 3 이상 20 이하여야 하고 U 또는 D만 포함할 수 있습니다." }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move(moving: String) {
        check(running()) { "게임이 실행되었을 때만 움직일 수 있습니다." }
        userHistory += moving
        movingEventManager.notify(GameMapStatus(bridge, userHistory))
        if (moveFailed())
            gameStatus = GameStatus.STOPPED
        if (successed()) quit()
    }

    private fun moveFailed() = userHistory.last() != bridge[userHistory.size - 1]

    fun successed(): Boolean {
        check(started()) { "게임이 시작되어야 성공했는지 판단할 수 있습니다." }
        if (bridge.size != userHistory.size)
            return false
        return (0 until userHistory.size).all { bridge[it] == userHistory[it] }
    }

    fun quit() {
        quitEventManager.notify(GameMapStatus(bridge, userHistory), GameResult(successed(), attempts))
        gameStatus = GameStatus.FINISHED
    }

    fun running(): Boolean = gameStatus == GameStatus.RUNNING

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {
        check(started() && !running()) { "게임이 중지 상태일 때만 재시작할 수 있습니다." }
        userHistory.clear()
        gameStatus = GameStatus.RUNNING
        attempts++
    }
}
