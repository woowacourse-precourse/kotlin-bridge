package bridge.view

import bridge.model.BridgeGame
import bridge.model.Direction

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(bridgeGame: BridgeGame) {
        val upLine = getLineOfMap(bridgeGame, Direction.U)
        val downLine = getLineOfMap(bridgeGame, Direction.D)
        println(upLine)
        println(downLine)
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
        sb.removeRange(sb.length - 1 until sb.length)
        sb.append(LINE_END)
        return sb.toString()
    }

    private fun getMovingResult(result: Boolean): String {
        return if (result) {
            MOVING_SUCCESS
        } else {
            MOVING_FAIL
        }
    }

    companion object {
        private const val FINAL_GAME_RESULT = "최종 게임 결과"
        private const val GAME_PASS_RESULT_FORMAT = "게임 성공 여부: %s"
        private const val GAME_TRY_NUMBER_FORMAT = "총 시도한 횟수: %d"

        private const val MOVING_SUCCESS = " O "
        private const val MOVING_FAIL = " X "
        private const val NOT_SELECTED_DIRECTION = " "

        private const val LINE_START = "["
        private const val LINE_END = "]"
        private const val LINE_SEPARATOR = "|"
    }
}
