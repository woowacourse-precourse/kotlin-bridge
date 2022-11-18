package bridge.view

import bridge.model.BridgeGame
import bridge.model.Direction

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    fun printStartText() {
        println(GAME_START_TEXT + "\n")
    }

    fun printRequireBridgeSize() {
        println(REQUIRE_BRIDGE_SIZE)
    }

    fun printRequireMoving() {
        println("\n" + REQUIRE_MOVING)
    }

    fun printRequireGameCommand() {
        println("\n" + REQUIRE_GAME_COMMAND)
    }

    fun printException(exception: Exception) {
        println("$ERROR_PREFIX ${exception.message}")
    }

    fun printMap(bridgeGame: BridgeGame) {
        printLine(bridgeGame, Direction.UP)
        printLine(bridgeGame, Direction.DOWN)
    }

    fun printResult(bridgeGame: BridgeGame) {
        println(FINAL_GAME_RESULT)
        printMap(bridgeGame)
        println()
        println(GAME_PASS_RESULT_FORMAT.format(bridgeGame.state.toString()))
        println(GAME_TRY_NUMBER_FORMAT.format(bridgeGame.tryCount))
    }

    private fun printLine(bridgeGame: BridgeGame, direction: Direction) {
        val directionMarkers = bridgeGame.movingTrace.map { getDirectionMarker(direction, it) }
        val line = directionMarkers.joinToString(LINE_SEPARATOR)
        println("$LINE_START $line $LINE_END")
    }

    private fun getDirectionMarker(direction: Direction, result: BridgeGame.MovingResult): String {
        if (result.direction == direction) {
            return getMatchedMarker(result.success)
        }
        return NOT_SELECTED_DIRECTION
    }

    private fun getMatchedMarker(match: Boolean): String {
        if (match) {
            return MOVING_SUCCESS
        }
        return MOVING_FAIL
    }

    companion object {
        private const val GAME_START_TEXT = "다리 건너기 게임을 시작합니다."
        private const val REQUIRE_BRIDGE_SIZE = "다리의 길이를 입력해주세요."
        private const val REQUIRE_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)"
        private const val REQUIRE_GAME_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"
        private const val FINAL_GAME_RESULT = "최종 게임 결과"
        private const val GAME_PASS_RESULT_FORMAT = "게임 성공 여부: %s"
        private const val GAME_TRY_NUMBER_FORMAT = "총 시도한 횟수: %d"
        private const val ERROR_PREFIX = "[ERROR]"

        private const val MOVING_SUCCESS = "O"
        private const val MOVING_FAIL = "X"
        private const val NOT_SELECTED_DIRECTION = " "

        private const val LINE_START = "["
        private const val LINE_END = "]"
        private const val LINE_SEPARATOR = " | "
    }
}
