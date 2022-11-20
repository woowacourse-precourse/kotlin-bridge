package bridge

object ExceptionHandler {
    /**
     * 입력값이 숫자가 아니면 예외를 던지는 함수
     */
    fun validateIntType(input: String){
        requireNotNull(input.toIntOrNull()) { "하하" }
    }

    /**
     * 입력한 다리 길이가 3과 20 사이가 아니면 예외를 던지는 함수
     */
    fun validateInRange(inputBridgeSize: Int){
        require(inputBridgeSize in 3..20) {"하하"}
    }

    /**
     * 입력한 이동할 칸이 U 이나 D 가 아닐 경우 예외를 던지는 함수
     */
    fun validateMoveLaneSymbol(inputMoveLane: String){
        require(inputMoveLane == "U" || inputMoveLane == "D") {"하하"}
    }

    /**
     * 입력한 재시도 여부 문자가 R 이나 Q 가 아닐 경우 예외를 던지는 함수
     */
    fun validateRetrialSymbol(inputRetrialSymbol: String){
        require(inputRetrialSymbol == "R" || inputRetrialSymbol == "Q") {"하하"}
    }

}

fun main(){
    ExceptionHandler.validateIntType(("4"))
}