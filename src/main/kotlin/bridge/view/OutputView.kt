package bridge.view

import bridge.BridgeGameStatus
import bridge.MovementStatus
import bridge.model.BridgeGameMetadataDTO

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    private var lowerBridge = ""
    private var upperBridge = ""

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
        drawStartOfBridge()
        drawBridge(metadata.getMovementStatuses())
        drawEndOfBridge()

        println(upperBridge)
        println(lowerBridge)
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(metadata: BridgeGameMetadataDTO) {
        println(GAME_RESULT_ANNOUNCEMENT)
        printMap(metadata)

        println()

        printGameStatus(metadata.getGameStatus())
        printTrialCount(metadata.getTrialCount())
    }

    private fun drawStartOfBridge() {
        upperBridge = "$START_OF_BRIDGE"
        lowerBridge = "$START_OF_BRIDGE"
    }

    private fun drawBridge(movementStatuses: List<MovementStatus>) {
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

    private fun drawEndOfBridge() {
        upperBridge += "$END_OF_BRIDGE"
        lowerBridge += "$END_OF_BRIDGE"
    }

    private fun printGameStatus(gameStatus: BridgeGameStatus) {
        println("$GAME_STATUS_ANNOUNCEMENT ${gameStatus.message}")
    }

    private fun printTrialCount(trialCount: Int) {
        println("$GAME_TRIAL_COUNT_ANNOUNCEMENT $trialCount")
    }

    companion object {
        const val BRIDGE_SEPARATION = " | "
        const val END_OF_BRIDGE = " ]"
        const val GAME_RESULT_ANNOUNCEMENT = "최종 게임 결과"
        const val GAME_START_ANNOUNCEMENT = "다리 건너기 게임을 시작합니다."
        const val GAME_STATUS_ANNOUNCEMENT = "게임 성공 여부:"
        const val GAME_TRIAL_COUNT_ANNOUNCEMENT = "총 시도한 횟수:"
        const val NOT_SELECTED = " "
        const val START_OF_BRIDGE = "[ "
        const val START_OF_ERROR_MESSAGE = "[ERROR]"
    }
}
