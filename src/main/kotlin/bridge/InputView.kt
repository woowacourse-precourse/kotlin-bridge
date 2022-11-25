package bridge

import camp.nextstep.edu.missionutils.Console
import java.lang.Exception
import java.util.regex.Pattern

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        return try{
            val input = Console.readLine()!!
            checkInputIsDigit(input)
            val bridgeSize = input.toInt()
            checkValidBridgeSize(bridgeSize)
            bridgeSize
        } catch (e: IllegalArgumentException){
            println(EXCEPTION_WRONG_SIZE)
            throw e
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        return try {
            val input = Console.readLine()!!
            checkValidMoveInput(input)
            input
        } catch (e: IllegalArgumentException){
            println(EXCEPTION_WRONG_MOVE)
            throw e
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        return try{
            val input = Console.readLine()!!
            checkValidRestartInput(input)
            input
        } catch (e: IllegalArgumentException){
            println(EXCEPTION_WRONG_RESTART)
            throw e
        }
    }
}
