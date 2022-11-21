package bridge

class ValidationInput {
    fun validateSizeValue(sizeValue: String) {
        if (sizeValue.toIntOrNull() == null) {
            java.lang.IllegalArgumentException()
            println(SIZE_VALUE_TYPE_ERROR)
        }
        if (sizeValue.toInt() !in 3..20) {
            java.lang.IllegalArgumentException()
            println(SIZE_VALUE_RANGE_ERROR)
        }

    }

    fun validateDirectionValue(directionValue: String) {
        if (directionValue != UP_DIRECTION_VALUE
                || directionValue != UP_DIRECTION_VALUE.lowercase()
                || directionValue != DOWN_DIRECTION_VALUE
                || directionValue != DOWN_DIRECTION_VALUE.lowercase()
        ) {
            java.lang.IllegalArgumentException()
            println(DIRECTION_VALUE_ERROR)
        }
    }

    fun validateRetryValue(retryValue: String) {
        if (retryValue != RETRY_GAME_VALUE
                || retryValue != RETRY_GAME_VALUE.lowercase()
                || retryValue != QUIT_GAME_VALUE
                || retryValue != QUIT_GAME_VALUE.lowercase()
        ) {
            java.lang.IllegalArgumentException()
            println(RETRY_VALUE_ERROR)
        }
    }

    fun getMoveUpValue() = UP_DIRECTION_VALUE

    fun getMoveDownValue() = DOWN_DIRECTION_VALUE

    fun getRetryGameValue() = RETRY_GAME_VALUE

    fun getQuitGameValue() = QUIT_GAME_VALUE

    companion object {
        const val UP_DIRECTION_VALUE = "U"
        const val DOWN_DIRECTION_VALUE = "D"
        const val RETRY_GAME_VALUE = "R"
        const val QUIT_GAME_VALUE = "Q"
        const val SIZE_VALUE_TYPE_ERROR = "[ERROR] 다리 길이는 공백 없이 정수 형태의 값이여야 합니다."
        const val SIZE_VALUE_RANGE_ERROR = "[ERROR] 다리 길이는 3 이상 20 이하의 수여야 합니다."
        const val DIRECTION_VALUE_ERROR = "[ERROR] 이동 방향은 U 또는 u, D 또는 d 의 값만 입력 가능합니다."
        const val RETRY_VALUE_ERROR = "[ERROR] 재시작 여부는 R 또는 r, Q 또는 q 의 값만 입력 가능합니다."
    }
}