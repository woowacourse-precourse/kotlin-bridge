package bridge.utils
import bridge.utils.Constants.ERROR_BRIDGE_SIZE_NOT_IN_3_AND_20_MESSAGE
import bridge.utils.Constants.ERROR_NOT_INT_TYPE_MESSAGE
import bridge.utils.Constants.ERROR_NOT_U_OR_D_MESSAGE
import bridge.utils.Constants.ERROR_NOT_R_OR_Q_MESSAGE

object ExceptionHandler {
    /**
     * 입력값이 숫자가 아니면 예외를 던지는 함수
     */
    fun validateIntType(input: String){
        requireNotNull(input.toIntOrNull()) { ERROR_NOT_INT_TYPE_MESSAGE }
    }

    /**
     * 입력한 다리 길이가 3과 20 사이가 아니면 예외를 던지는 함수
     */
    fun validateInRange(inputBridgeSize: Int){
        require(inputBridgeSize in 3..20) { ERROR_BRIDGE_SIZE_NOT_IN_3_AND_20_MESSAGE}
    }

    /**
     * 입력한 이동할 칸이 U 이나 D 가 아닐 경우 예외를 던지는 함수
     */
    fun validateMoveLaneSymbol(inputMoveLaneSymbol: String){
        require(inputMoveLaneSymbol == "U" || inputMoveLaneSymbol == "D") { ERROR_NOT_U_OR_D_MESSAGE}
    }

    /**
     * 입력한 재시도 여부 문자가 R 이나 Q 가 아닐 경우 예외를 던지는 함수
     */
    fun validateRetrialSymbol(inputRetrialSymbol: String){
        require(inputRetrialSymbol == "R" || inputRetrialSymbol == "Q") { ERROR_NOT_R_OR_Q_MESSAGE}
    }
}

