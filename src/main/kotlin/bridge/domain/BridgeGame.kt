package bridge.domain

import bridge.constants.String.Companion.STRING_CORRECT
import bridge.constants.String.Companion.STRING_RETRY
import bridge.constants.String.Companion.STRING_WRONG

class BridgeGame {
    fun move(moving: String, answer: String): String {
        return getSymbol(moving, answer)
    }

    private fun getSymbol(moving: String, answer: String): String {
        if (judgeCorrect(moving, answer)) {
            return STRING_CORRECT
        }
        return STRING_WRONG
    }

    private fun judgeCorrect(moving: String, answer: String): Boolean {
        if (moving == answer) {
            return true
        }
        return false
    }

    fun retry(command: String): Boolean {
        if (command == STRING_RETRY) {
            return true
        }
        return false
    }
}
