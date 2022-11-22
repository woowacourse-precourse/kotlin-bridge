package bridge.view

import bridge.model.BridgeResult

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(bridgesResult: BridgeResult) {
        println(bridgesResult.upBridgeResult())
        println(bridgesResult.downBridgeResult())
        println()
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(bridgeResult : BridgeResult) {
        println(FINAL_RESULT_MESSAGE)
        printMap(bridgeResult)
    }

    fun pringGameStartMessage() {
        println(GAME_START_MESSAGE)
        println()
    }

    fun printError(error : IllegalArgumentException) {
        println(error.message)
    }

    fun printInputBridgeSizeMessage() {
        println(BRIDGE_SIZE_INPUT_MESSAGE)
    }

    fun printInputMoveDirectionMessage() {
        println(MOVE_DIRECTION_INPUT_MESSAGE)
    }

    fun printInputRestartMessage() {
        println(RESTART_MESSAGE)
    }

    fun printSuccessFail(bridgeResult: BridgeResult) {
        val result = bridgeResult.getGameResult()
        println(BRIDGE_GAME_CHECK_SUCCESS_MESSAGE + result.getResultMessage())
    }

    fun printGameCount(count : Int) {
        println(BRIDGE_GAME_COUNT_MESSAGE + count)
    }

    companion object {
        const val GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다."
        const val BRIDGE_SIZE_INPUT_MESSAGE = "다리의 길이를 입력해주세요."
        const val MOVE_DIRECTION_INPUT_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)"
        const val RESTART_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"
        const val FINAL_RESULT_MESSAGE = "최종 게임 결과"
        const val BRIDGE_GAME_CHECK_SUCCESS_MESSAGE= "게임 성공 여부: "
        const val BRIDGE_GAME_COUNT_MESSAGE = "총 시도한 횟수: "
    }
}
