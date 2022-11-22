package view

import camp.nextstep.edu.missionutils.Console
import util.InputException
import util.InputException.Companion.RANGE_ERROR


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

    private fun getMoveCommand() {
        val command = Console.readLine()

    }

//    private fun getBridgeSize(): String {
//        val size = Console.readLine()
//        val inputCheck = inputException.checkRangeException(size)
//        if (!inputCheck)
//            return " "
//        return size
//    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
//        while (true) {
//            val command =
//            try {
//                require(inputException.checkMoveCommand(i))
//            } catch (e: IllegalArgumentException) {
//
//            }
//        }
        val command = Console.readLine()
        inputException.checkMoveCommand(command)
        return command
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        val command = Console.readLine()
        inputException.checkRetryCommand(command)
        return command
    }
}
