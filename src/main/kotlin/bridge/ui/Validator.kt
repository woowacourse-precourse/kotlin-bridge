package bridge.ui

import bridge.utils.*

class Validator {
    fun handleMixedCharCase(input: String) {
        for (ch in input) {
            if (!Character.isDigit(ch)){
                // 음수인 경우 다른 함수에서 처리하도록
                if(ch == '-' && input.toInt() < 0) continue
                throw IllegalArgumentException(MIXED_CHAR_ERROR_MSG)
            }
        }
    }

    fun handleOutOfRangeCase(num: Int) {
        if (num !in MIN_SIZE..MAX_SIZE)
            throw IllegalArgumentException(RANGE_BOUNDS_ERROR_MSG)
    }

    fun handleExceptionalDirection(input: String) {
        if(input != UP && input != DOWN)
            throw IllegalArgumentException(UP_DOWN_ERROR_MSG)
    }

    fun handleExceptionalCommand(input: String) {
        if(input != RESTART && input != QUIT)
            throw IllegalArgumentException(RESTART_QUIT_ERROR_MSG)
    }
}