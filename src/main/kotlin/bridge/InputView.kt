package bridge

import camp.nextstep.edu.missionutils.Console
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
        while (true) {
            println(Output.INPUT_LENGTH.output)
            val bridgeSize = ExceptionHandler.isInt()
            if (!ExceptionHandler.rangeException(bridgeSize)) {
                continue
            } else {
                return bridgeSize
            }
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        while (true) {
            println(Output.SELECT_SPACE.output)
            val moving = Console.readLine()!!
            if (!ExceptionHandler.specificAlphabetUD(moving)) {
                continue
            } else {
                return moving
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        while (true) {
            println(Output.TRY_OR_NOT.output)
            val gameCommand = Console.readLine()!!
            if (!ExceptionHandler.specificAlphabetRQ(gameCommand)) {
                continue
            } else {
                return gameCommand
            }
        }
    }
}
