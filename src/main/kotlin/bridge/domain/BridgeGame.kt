package bridge.domain

import bridge.BridgeGameStatus
import bridge.MovementStatus
import bridge.model.BridgeDTO
import bridge.model.BridgeGameMetadataDTO

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame {
    private lateinit var bridge: List<String>
    private lateinit var gameStatus: BridgeGameStatus
    private var movementCount = 0
    private val movementStatuses = mutableListOf<MovementStatus>()
    private var trialCount = 1

    fun setBridge(bridgeDTO: BridgeDTO) {
        bridge = bridgeDTO.getBridge()
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move(movement: String): BridgeGameMetadataDTO {
        val movementStatus = checkMovementStatus(movement)
        movementStatuses.add(movementStatus)
        movementCount++

        gameStatus = checkGameStatus(movementStatus)

        return BridgeGameMetadataDTO(gameStatus, movementStatuses, trialCount)
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {
        movementCount = 0
        movementStatuses.clear()
        trialCount++
    }

    private fun checkMovementStatus(movement: String): MovementStatus {
        val answer = bridge[movementCount]
        if (movement == answer) {
            return checkRightMovementStatus(movement)
        }
        return checkWrongMovementStatus(movement)
    }

    private fun checkRightMovementStatus(movement: String): MovementStatus {
        if (movement == "U") {
            return MovementStatus.UP_RIGHT
        }
        return MovementStatus.DOWN_RIGHT
    }

    private fun checkWrongMovementStatus(movement: String): MovementStatus {
        if (movement == "U") {
            return MovementStatus.UP_WRONG
        }
        return MovementStatus.DOWN_WRONG
    }

    private fun checkGameStatus(movementStatus: MovementStatus): BridgeGameStatus {
        if (movementStatus.status == "X") {
            return BridgeGameStatus.FAILURE
        }

        if (movementCount == bridge.size) {
            return BridgeGameStatus.SUCCESS
        }
        return BridgeGameStatus.CONTINUE
    }
}
