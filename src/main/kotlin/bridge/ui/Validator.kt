package bridge.ui

import bridge.utils.MAX_SIZE
import bridge.utils.MIN_SIZE
import bridge.utils.MIXED_CHAR_ERROR_MSG
import bridge.utils.RANGE_BOUNDS_ERROR_MSG

class Validator {
    fun handleMixedCharCase(token: String) {
        for (ch in token) {
            if (!Character.isDigit(ch)){
                // 음수인 경우 다른 함수에서 처리하도록
                if(ch == '-' && token.toInt() < 0) continue
                throw IllegalArgumentException(MIXED_CHAR_ERROR_MSG)
            }
        }
    }

    fun handleOutOfRangeCase(num: Int) {
        if (num !in MIN_SIZE..MAX_SIZE)
            throw IllegalArgumentException(RANGE_BOUNDS_ERROR_MSG)
    }
}