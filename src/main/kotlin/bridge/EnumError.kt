package bridge

interface EnumErrorInterface {
    fun checkErrorType(type: ErrorType) : String
}

class EnumError() : EnumErrorInterface {
    override fun checkErrorType(type: ErrorType): String {
        return when(type) {
            ErrorType.InputIsNull -> "입력값은 공백일 수 없습니다."
            ErrorType.BridgeLengthNotInRange -> "다리 길이는 3부터 20 사이의 숫자여야 합니다."
            ErrorType.InputIncludeWords -> "입력값은 숫자로만 이루어져야 합니다."
            ErrorType.NotDefinedMovementInput -> "올바르지 않은 칸 이동 입력값입니다. 대문자 U 혹은 대문자 D로만 입력해주세요."
            ErrorType.MovementInputShouldBeSingleLetter -> "이동할 칸 입력값은 한 글자로만 이루어져야 합니다."
            ErrorType.NotDefinedRetryInput -> "올바르지 않은 재도전 입력값입니다. R 혹은 Q로만 입력해주세요."
        }
    }
}

enum class ErrorType() {
    BridgeLengthNotInRange,
    InputIsNull,
    InputIncludeWords,
    NotDefinedMovementInput,
    MovementInputShouldBeSingleLetter,
    NotDefinedRetryInput
}