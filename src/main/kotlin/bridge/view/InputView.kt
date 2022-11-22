package bridge.view

import bridge.util.Exceptions
import bridge.util.INPUT_BRIDGE_SIZE
import bridge.util.RESTART_OR_QUIT
import bridge.util.SELECT_KEY_TO_MOVE

import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        println(INPUT_BRIDGE_SIZE)
        return try {
            val number = Console.readLine()
            Exceptions.checkInputBrideSize(number)
            println()
            return number.toInt()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            readBridgeSize()
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        println(SELECT_KEY_TO_MOVE)
        return try {
            val move = Console.readLine()
            Exceptions.checkInputMoveKey(move)
            return move
        } catch (e: IllegalArgumentException) {
            println(e.message)
            readMoving()
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        println(RESTART_OR_QUIT)
        return try {
            val command = Console.readLine()
            Exceptions.checkInputCommandKey(command)
            return command
        } catch (e: IllegalArgumentException) {
            println(e.message)
            readGameCommand()
        }
    }
}
