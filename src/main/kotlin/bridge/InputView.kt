package bridge

import camp.nextstep.edu.missionutils.Console
import output.ErrorMessage
import output.ExceptionHandler
import output.Output

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        println(Output.INPUT_LENGTH.output)
        val bridgeSize = try {
            Console.readLine()!!.toInt()
        } catch (e: NumberFormatException) {
            println(ErrorMessage.ONLY_NUMBER.errorMessage)
            readBridgeSize()
        }
        if (!ExceptionHandler.rangeException(bridgeSize)) {
            println(ErrorMessage.RANGE.errorMessage)
            readBridgeSize()
        }
        return bridgeSize
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        println(Output.SELECT_SPACE.output)
        val moving = Console.readLine()!!
        if (!ExceptionHandler.specificAlphabetUD(moving)) {
            println(ErrorMessage.UD.errorMessage)
            readMoving()
        }
        return moving
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        println(Output.TRY_OR_NOT.output)
        val gameCommand = Console.readLine()!!
        if (!ExceptionHandler.specificAlphabetRQ(gameCommand)) {
            println(ErrorMessage.RQ.errorMessage)
            readGameCommand()
        }
        return gameCommand
    }
}
