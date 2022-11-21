package bridge.model

import bridge.model.data.Direction
import bridge.model.data.GameStatus
import bridge.model.data.PlayerStatus

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(
    private val bridgeMaker: BridgeMaker,
) {
    private var playerPosition = 0
    private lateinit var bridge: List<String>

    fun initBridge(bridgeSize: Int) {
        bridge = bridgeMaker.makeBridge(bridgeSize)
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move(playerDirection: String): PlayerStatus {
        val isPlayerAlive = when (playerDirection) {
            bridge[playerPosition++] -> true
            else -> false
        }

        return PlayerStatus(playerDirection.directionToNumber(), isPlayerAlive)
    }

    /**
     * 한 번의 이동이 끝나고 게임이 계속되는지 성공했는지 실패했는지를 확인하는 메서드
     */
    fun checkGameStatus(isPlayerAlive: Boolean) = when {
        !isPlayerAlive -> GameStatus.FAILED
        playerPosition == bridge.size -> GameStatus.SUCCEEDED
        else -> GameStatus.CONTINUING
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {
        playerPosition = 0
    }

    private fun String.directionToNumber() = if (this == Direction.DOWN.direction) {
        Direction.DOWN.directionNumber
    } else {
        Direction.UP.directionNumber
    }

}
