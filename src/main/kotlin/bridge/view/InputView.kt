package bridge.view

import bridge.utils.UserInputValidate
import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        val inputBridgeSize = Console.readLine()
        isValidType(inputBridgeSize)
        isValidInputRange(inputBridgeSize.toInt())
        return inputBridgeSize.toInt()
    }

    private fun isNumber(s: String?): Boolean {
        return if (s.isNullOrEmpty()) false else s.all { Character.isDigit(it) }
    }

    private fun isValidType(bridgeSize: String) {
        if (!isNumber(bridgeSize)) {
            throw IllegalArgumentException("[ERROR]: 다리의 길이는 숫자로만 입력되어야 합니다.")
        }
    }

    private fun isValidInputRange(bridgeSize: Int) {
        if (bridgeSize < MIN_BRIDGE_SIZE || MAX_BRIDGE_SIZE > 20) {
            throw IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.")
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        return ""
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        return ""
    }

    companion object {
        const val MIN_BRIDGE_SIZE = 3
        const val MAX_BRIDGE_SIZE = 20
    }
}
