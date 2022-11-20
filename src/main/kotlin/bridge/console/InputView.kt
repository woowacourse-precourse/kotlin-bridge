package bridge.console
import bridge.utils.ExceptionHandler.validateInRange
import bridge.utils.ExceptionHandler.validateIntType
import bridge.utils.ExceptionHandler.validateMoveLaneSymbol
import bridge.utils.ExceptionHandler.validateRetrialSymbol

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        val inputBridgeSize = readLine()
        validateIntType(inputBridgeSize!!)
        validateInRange(inputBridgeSize.toInt())
        return inputBridgeSize.toInt()
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        val inputMoveLaneSymbol = readLine()
        validateMoveLaneSymbol(inputMoveLaneSymbol!!)
        return inputMoveLaneSymbol
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        val inputRetrialSymbol = readLine()
        validateRetrialSymbol(inputRetrialSymbol!!)
        return inputRetrialSymbol
    }
}
