package bridge.computer

import bridge.utils.Constants

enum class ErrorMessage(val messages: String)  {
    OCCUR("[ERROR] ERROR_MESSAGE"),
    NUMBER_TYPE("[ERROR] 숫자가 아닙니다."),
    RANGE("[ERROR] 숫자범위가 초과되었습니다."),
    STRING("[ERROR] 잘못된 문자를 입력했습니다."),
}

class ErrorCheck() {
    fun BridgeSize(input: Int) {
        if (input < Constants.BridgeMinRange || input > Constants.BridgeMaxRange) {
            throw IllegalArgumentException(ErrorMessage.RANGE.messages)
        }
    }

    fun MoveKeyWordisNotNumber(input: String) {
        try {
            input.toInt()
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException(ErrorMessage.NUMBER_TYPE.messages)
        }
    }

    fun MoveKeyWordisDiffer(input: String) {
        if (input != "U" && input != "D") {
            throw IllegalArgumentException(ErrorMessage.STRING.messages)
        }
    }

    fun ReTrykeyWordld(input: String) {
        if (input != "R" && input != "Q") {
            throw IllegalArgumentException(ErrorMessage.STRING.messages)
        }
    }
}