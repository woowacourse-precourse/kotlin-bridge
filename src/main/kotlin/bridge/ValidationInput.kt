package bridge

import java.lang.IllegalArgumentException

class ValidationInput {
    fun validateSizeValue(sizeValue: String) {
        if (sizeValue.toIntOrNull() == null) {
            throw IllegalArgumentException()
        }
        if (sizeValue.toInt() !in 3..20) {
            throw IllegalArgumentException()
        }
    }

    fun validateDirectionValue(directionValue: String) {
        if (directionValue.uppercase() != UP_DIRECTION_VALUE
                && directionValue.uppercase() != DOWN_DIRECTION_VALUE) {
            throw IllegalArgumentException()
        }
    }

    fun validateCommandValue(retryValue: String) {
        if (retryValue.uppercase() != RETRY_GAME_VALUE
                && retryValue.uppercase() != QUIT_GAME_VALUE) {
            throw IllegalArgumentException()
        }
    }

    fun getUpDirectionValue() = UP_DIRECTION_VALUE

    fun getDownDirectionValue() = DOWN_DIRECTION_VALUE

    fun getRetryGameValue() = RETRY_GAME_VALUE

    fun getQuitGameValue() = QUIT_GAME_VALUE

    companion object {
        const val UP_DIRECTION_VALUE = "U"
        const val DOWN_DIRECTION_VALUE = "D"
        const val RETRY_GAME_VALUE = "R"
        const val QUIT_GAME_VALUE = "Q"
        const val SIZE_VALUE_ERROR = "[ERROR] 다리 길이는 공백 없이 3 이상 20 이하의 값이여야 합니다."
        const val DIRECTION_VALUE_ERROR = "[ERROR] 이동 방향은 U 또는 u, D 또는 d 의 값만 입력 가능합니다."
        const val COMMAND_VALUE_ERROR = "[ERROR] 재시작 여부는 R 또는 r, Q 또는 q 의 값만 입력 가능합니다."
    }
}