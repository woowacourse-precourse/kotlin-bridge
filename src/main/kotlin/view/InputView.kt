package view

import camp.nextstep.edu.missionutils.Console
import util.InputException
import data.BridgeStore.COMMAND_ERROR
import data.BridgeStore.RANGE_ERROR
import data.BridgeStore.RETRY_ERROR


/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    private val inputException = InputException()

    fun readBridgeSize(): Int {
        while (true) {
            val size = Console.readLine()
            try {
                inputException.checkRangeException(size)
                return size.toInt()
            } catch (e: IllegalArgumentException) {
                inputException.printException(RANGE_ERROR)
            }
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        while (true) {
            val command = Console.readLine()
            try {
                inputException.checkMoveCommand(command)
                return command
            } catch (e: IllegalArgumentException) {
                inputException.printException(COMMAND_ERROR)
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        while (true) {
            val command = Console.readLine()
            try {
                inputException.checkRetryCommand(command)
                return command
            } catch (e: IllegalArgumentException) {
                inputException.printException(RETRY_ERROR)
            }
        }
    }
}
