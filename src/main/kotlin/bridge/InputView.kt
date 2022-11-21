package bridge

import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        println(READ_BRIDGE_SIZE)
        val userInput = Console.readLine()
        if (!bridgeSizeIsValid(userInput)){
            throw IllegalArgumentException(READ_BRIDGE_SIZE_ERROR_MESSAGE)
        }
        return userInput.toInt()
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        return Console.readLine().toString()
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        return Console.readLine().toString()
    }



    private fun bridgeSizeIsValid(userInput: String?): Boolean {
        if (userInput.isNullOrBlank()) {
            return false
        }
        if (!isNumber(userInput)) {
            return false
        }
        if (userInput.toInt() !in BRIDGE_MIN_SIZE..BRIDGE_MAX_SIZE) {
            return false
        }
        return true
    }


    private fun isNumber(elementString: String): Boolean {
        return try {
            elementString.toInt()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }


    companion object {
        const val READ_BRIDGE_SIZE = "다리의 길이를 입력해주세요."
        const val READ_BRIDGE_SIZE_ERROR_MESSAGE = "[ERROR] 다리 길이는 3이상 20이하의 숫자를 입력해야 합니다."
        const val BRIDGE_MAX_SIZE = 20
        const val BRIDGE_MIN_SIZE = 3

    }


}
