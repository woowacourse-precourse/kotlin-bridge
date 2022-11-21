package bridge

import bridge.BridgeGame.Companion.MOVING_DIRECT_DOWN
import bridge.BridgeGame.Companion.MOVING_DIRECT_UP
import bridge.GameView.Companion.ERROR_MESSAGE_INPUT_BRIDGE_LENGTH
import bridge.GameView.Companion.ERROR_MESSAGE_INPUT_GAME_COMMAND
import bridge.GameView.Companion.ERROR_MESSAGE_INPUT_MOVING
import bridge.GameView.Companion.ERROR_MESSAGE_PREFIX
import bridge.GameView.Companion.ERROR_MESSAGE_UNKNOWN
import bridge.GameView.Companion.FAILURE
import bridge.GameView.Companion.MESSAGE_GAME_COUNT
import bridge.GameView.Companion.MESSAGE_GAME_RESULT
import bridge.GameView.Companion.MESSAGE_GAME_START
import bridge.GameView.Companion.SUCCESS
import bridge.exception.BridgeSizeInvalidException
import bridge.exception.GameCommandInvalidException
import bridge.exception.MovingInvalidException

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    private val upMap: StringBuilder by lazy { StringBuilder() }
    private val downMap: StringBuilder by lazy { StringBuilder() }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(
        turn: Int,
        moveResult: Char,
        moveDirect: String,
    ) {
        if (turn == 0)
            clearMap()
        else
            fixMap()
        fillMap(moveResult, moveDirect)
        println("${upMap}\n$downMap")
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(playCount: Int, gameResult: Boolean) {
        println(
            MESSAGE_GAME_RESULT.format(
                if (gameResult) SUCCESS else FAILURE
            )
        )
        println(
            MESSAGE_GAME_COUNT.format(playCount)
        )
    }

    fun printGameStart() {
        println(MESSAGE_GAME_START)
    }

    fun printInputNotice(inputType: InputType) {
        println(
            when (inputType) {
                InputType.BRIDGE_SIZE -> InputType.BRIDGE_SIZE.message
                InputType.MOVING -> InputType.MOVING.message
                InputType.GAME_COMMAND -> InputType.GAME_COMMAND.message
            }
        )
    }

    private fun fillMap(moveResult: Char, moveDirect: String) {
        val message = " %c "
        upMap.append(
            message.format(
                if (moveDirect == MOVING_DIRECT_UP) moveResult else ' ')
        )
        downMap.append(
            message.format(
                if (moveDirect == MOVING_DIRECT_DOWN) moveResult else ' ')
        )
        upMap.append("]")
        downMap.append("]")
    }

    private fun clearMap() {
        upMap.clear()
        downMap.clear()
        upMap.append("[")
        downMap.append("[")
    }

    private fun fixMap() {
        upMap.deleteCharAt(upMap.lastIndex)
        downMap.deleteCharAt(downMap.lastIndex)
        upMap.append("|")
        downMap.append("|")
    }

    companion object {
        fun printErrorMessage(e: Exception) {
            println(ERROR_MESSAGE_PREFIX +
                when (e) {
                    is BridgeSizeInvalidException -> ERROR_MESSAGE_INPUT_BRIDGE_LENGTH
                    is MovingInvalidException -> ERROR_MESSAGE_INPUT_MOVING
                    is GameCommandInvalidException -> ERROR_MESSAGE_INPUT_GAME_COMMAND
                    else -> ERROR_MESSAGE_UNKNOWN
                }
            )
        }
    }
}
