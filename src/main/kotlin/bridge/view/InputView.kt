package bridge.view

import bridge.Exception.BridgeLengthException
import bridge.Exception.MoveException
import bridge.resources.*
import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        println(INPUT_BRIDGE_LENGTH)
        val inputBridgeSize = input()

        BridgeLengthException.exceptions(inputBridgeSize)
        return inputBridgeSize.toInt()
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        println(INPUT_CHOICE_ROOM)
        val inputMove = input()

        MoveException.exceptions(inputMove)
        return inputMove
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        println(INPUT_CHOICE_RESTART)
        val checkRetry = input()


        return ""
    }

    private fun input() = Console.readLine()
}
