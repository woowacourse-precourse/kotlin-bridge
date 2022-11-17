package bridge.validation

class InputValidation {

    fun checkInputInteger(input:String){
        try {
            input.toInt()
        }catch (e:IllegalArgumentException){
            throw IllegalArgumentException(ErrorType.NOT_INTEGER_ERROR.message)
        }
    }

    enum class ErrorType(val message:String){
        NOT_INTEGER_ERROR("$INITIAL_ERROR_MESSAGE 정수가 아닌 수가 포함되어 있습니다(공백포함). 정수만 입력해 주세요."),

    }

    companion object{
        const val INITIAL_ERROR_MESSAGE = "[ERROR]"
    }
}