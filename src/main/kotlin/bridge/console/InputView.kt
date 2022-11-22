package bridge.console
import bridge.utils.Constants
import bridge.utils.ExceptionHandler.validateInRange
import bridge.utils.ExceptionHandler.validateIntType
import bridge.utils.ExceptionHandler.validateMoveLaneSymbol
import bridge.utils.ExceptionHandler.validateRetrialSymbol
import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        return try{
            inputBridgeSize()
        }catch (e: IllegalArgumentException){
            readBridgeSize()
        }
    }

    private fun inputBridgeSize(): Int{
        val inputBridgeSize = Console.readLine()
        validateIntType(inputBridgeSize)
        validateInRange(inputBridgeSize.toInt())
        return inputBridgeSize.toInt()
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        return try{
            inputMoveLaneSymbol()
        }catch (e: IllegalArgumentException){
            readMoving()
        }
    }

    private fun inputMoveLaneSymbol(): String{
        val inputMoveLaneSymbol = Console.readLine()
        validateMoveLaneSymbol(inputMoveLaneSymbol)
        return inputMoveLaneSymbol
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        return try{
            inputGameCommandSymbol()
        }catch (e: IllegalArgumentException){
            readGameCommand()
        }
    }

    private fun inputGameCommandSymbol(): String{
        val inputRetrialSymbol = Console.readLine()
        validateRetrialSymbol(inputRetrialSymbol)
        return inputRetrialSymbol
    }
}


