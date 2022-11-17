package bridge.validation

class InputValidation {

    fun checkInputInteger(input: String) {
        try {
            input.toInt()
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException(ErrorType.NOT_INTEGER_ERROR.message)
        }
    }

    fun checkBridgeSizeRange(size: Int) {
        if (size< MIN_BRIDGE_SIZE || size > MAX_BRIDGE_SIZE ) throw IllegalArgumentException(ErrorType.BRIDGE_SIZE_RANGE_ERROR.message)
    }

    fun checkInputLength(input: String){
        if(input.length!= CORRECT_INPUT_LENGTH) throw IllegalArgumentException(ErrorType.INCORRECT_INPUT_LENGTH_ERROR.message)
    }

    fun checkUserMovingValidation(input: String){
        if(!(input=="U" || input=="D")) throw IllegalArgumentException(ErrorType.INCORRECT_MOVING_INPUT_ERROR.message)
    }

    enum class ErrorType(val message: String) {
        NOT_INTEGER_ERROR("$INITIAL_ERROR_MESSAGE 정수가 아닌 수가 포함되어 있습니다(공백포함). 정수만 입력해 주세요."),
        BRIDGE_SIZE_RANGE_ERROR("$INITIAL_ERROR_MESSAGE 3이상 20이하의 숫자만 입력해주세요."),
        INCORRECT_INPUT_LENGTH_ERROR("$INITIAL_ERROR_MESSAGE 입력값의 길이는 1이어야 합니다(공백포함)."),
        INCORRECT_MOVING_INPUT_ERROR("$INITIAL_ERROR_MESSAGE 이동할 칸의 입력은 \"U\" 또는 \"D\" 만 가능합니다.")

    }

    companion object {
        const val INITIAL_ERROR_MESSAGE = "[ERROR]"
        const val MIN_BRIDGE_SIZE = 3
        const val MAX_BRIDGE_SIZE = 20
        const val CORRECT_INPUT_LENGTH =1
    }
}