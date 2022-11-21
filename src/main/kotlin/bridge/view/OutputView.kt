package bridge.view

import bridge.MovementStatus
import bridge.model.BridgeGameMetadataDTO

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    private var upperBridge = ""
    private var lowerBridge = ""

    fun printStartGame() {
        println(GAME_START_ANNOUNCEMENT)
    }

    fun printStepInterval() {
        println()
    }

    fun printErrorMessage(errorMessage: String) {
        println("$START_OF_ERROR_MESSAGE $errorMessage")
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(metadata: BridgeGameMetadataDTO) {
        upperBridge = "$START_OF_BRIDGE"
        lowerBridge = "$START_OF_BRIDGE"

        addBridge(metadata.getMovementStatuses())

        upperBridge += "$END_OF_BRIDGE"
        lowerBridge += "$END_OF_BRIDGE"

        println(upperBridge)
        println(lowerBridge)
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(metadata: BridgeGameMetadataDTO) {}

    private fun addBridge(movementStatuses: List<MovementStatus>) {
        for ((index, movementStatus) in movementStatuses.withIndex()) {
            if (index != 0) {
                upperBridge += "$BRIDGE_SEPARATION"
                lowerBridge += "$BRIDGE_SEPARATION"
            }
            addMovementStatus(movementStatus)
        }
    }

    private fun addMovementStatus(movementStatus: MovementStatus) {
        if (movementStatus.direction == "U") {
            upperBridge += movementStatus.status
            lowerBridge += "$NOT_SELECTED"
            return
        }
        lowerBridge += movementStatus.status
        upperBridge += "$NOT_SELECTED"
    }

    companion object {
        const val START_OF_BRIDGE = "[ "
        const val START_OF_ERROR_MESSAGE = "[ERROR]"
        const val BRIDGE_SEPARATION = " | "
        const val END_OF_BRIDGE = " ]"
        const val GAME_START_ANNOUNCEMENT = "다리 건너기 게임을 시작합니다."
        const val NOT_SELECTED = " "
    }
}
