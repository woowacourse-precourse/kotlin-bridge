package bridge.model

import bridge.BridgeGameStatus
import bridge.MovementStatus

class BridgeGameMetadataDTO(
    private val gameStatus: BridgeGameStatus,
    private val movementStatuses: List<MovementStatus>,
    private val trialCount: Int
) {
    fun getGameStatus(): BridgeGameStatus {
        return gameStatus
    }

    fun getMovementStatuses(): List<MovementStatus> {
        return movementStatuses
    }

    fun getTrialCount(): Int {
        return trialCount
    }
}