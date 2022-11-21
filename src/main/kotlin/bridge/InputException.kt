package bridge

import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

class InputException {

    fun checkInputIsNull(input : String){
        require(input.isNotEmpty()) { ERROR_HEADER + ERROR_NULL_INPUT }
    }

    fun checkBridgeLenInputIsNumeric(input : String){
        try {
            input.toInt()
        } catch (e : NumberFormatException){
            throw IllegalArgumentException(ERROR_HEADER + ERROR_BRIDGE_LEN_INPUT)
        }
    }

    companion object{
        const val ERROR_HEADER = "[ERROR]"

        const val ERROR_NULL_INPUT = "입력된 값이 없습니다."
        const val ERROR_BRIDGE_LEN_INPUT = "다리 길이는 숫자만 가능합니다."
    }

}