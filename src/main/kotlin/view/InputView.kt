package view

import camp.nextstep.edu.missionutils.Console
import util.InputException


/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    private val inputException = InputException()

    fun readBridgeSize(): Int {
        val size = Console.readLine()
        inputException.checkBridgeLength(size)
        return size.toInt()
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        val command = Console.readLine()
        inputException.checkMoveCommand(command)
        return command
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        return ""
    }
}
