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

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(bridgeGame: BridgeGame) {
        val upLine = getLineOfMap(bridgeGame, Direction.U)
        val downLine = getLineOfMap(bridgeGame, Direction.D)
        println(upLine)
        println(downLine + "\n")
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(bridgeGame: BridgeGame) {
        println(FINAL_GAME_RESULT)
        printMap(bridgeGame)
        println()
        println(GAME_PASS_RESULT_FORMAT.format(bridgeGame.state.toString()))
        println(GAME_TRY_NUMBER_FORMAT.format(bridgeGame.tryCount))
    }

    private fun getLineOfMap(bridgeGame: BridgeGame, direction: Direction): String {
        val movingTrace = bridgeGame.movingTrace
        val sb = StringBuilder(LINE_START)
        for (moving in movingTrace) {
            if (Direction.getByName(moving.first) == direction) {
                val result = getMovingResult(moving.second)
                sb.append(result)
            } else {
                sb.append(NOT_SELECTED_DIRECTION)
            }
            sb.append(LINE_SEPARATOR)
        }
        return sb.removeRange(sb.length - 3 until sb.length).toString() + LINE_END
    }

    private fun getMovingResult(result: Boolean): String {
        return if (result) {
            MOVING_SUCCESS
        } else {
            MOVING_FAIL
        }
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

        private const val LINE_START = "[ "
        private const val LINE_END = " ]"
        private const val LINE_SEPARATOR = " | "
    }
}
