package bridge.consol

import bridge.exceptions.ExceptionHandler
import camp.nextstep.edu.missionutils.Console


/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    fun readBridgeSize(): Int {
        return try {
            var bridgeSize = Console.readLine().toInt()
            ExceptionHandler.checkSize(bridgeSize)
        }catch (e: NumberFormatException) {
            println(ERROR_MESSAGE + NOT_NUMBER_ERROR)
            readBridgeSize()
        } catch (e: IllegalArgumentException) {
            println(ERROR_MESSAGE + e.message)
            readBridgeSize()
        }
    }

    fun readMoving(): String {
        return try {
            val upDown = Console.readLine()
            ExceptionHandler.checkUpDown(upDown)
            upDown
        } catch (e: IllegalArgumentException) {
            println(ERROR_MESSAGE + e.message)
            readMoving()
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        return try {
            val gameCommand = Console.readLine()
            ExceptionHandler.checkCommand(gameCommand)
            gameCommand
        } catch (e: IllegalArgumentException) {
            println(ERROR_MESSAGE + e.message)
            readGameCommand()
        }
    }
}
