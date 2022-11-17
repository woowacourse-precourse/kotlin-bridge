package bridge

import camp.nextstep.edu.missionutils.Console
import java.lang.Exception
import java.lang.NumberFormatException

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        return try{
            val input = Console.readLine()
            checkBridgeSizeException(input)
            input.toInt()
        } catch (exception : IllegalArgumentException){
            println("[ERROR] 입력값이 올바르지 않습니다.")
            readBridgeSize()
        }
    }

    private fun checkBridgeSizeException(input : String){
        if(!checkBridgeSizeScopeException(input) || !checkBridgeSizeIsNumeric(input)){
            require(false)
        }
    }

    private fun checkBridgeSizeScopeException(input : String) : Boolean{
        return input.toInt() in 1..20
    }

    private fun checkBridgeSizeIsNumeric(input : String) : Boolean{
        return input.all { char -> char.isDigit() }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        return ""
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        return ""
    }
}
